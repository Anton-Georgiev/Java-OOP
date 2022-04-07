package viceCity.core.interfaces;

import com.sun.source.tree.LiteralTree;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private MainPlayer mainPlayer;
    private List<Player> civilPlayerList;
    private GunRepository gunRepository;
    private GangNeighbourhood neighbourhood;

    public ControllerImpl(){
        mainPlayer = new MainPlayer();
        civilPlayerList = new ArrayList<>();
        gunRepository = new GunRepository();
        neighbourhood = new GangNeighbourhood();
    }
    @Override
    public String addPlayer(String name) {
        civilPlayerList.add(new CivilPlayer(name));
        return String.format(PLAYER_ADDED,name);
    }

    @Override
    public String addGun(String type, String name) {
            if (type.equals("Pistol")){
                gunRepository.add(new Pistol(name));
                return String.format(GUN_ADDED,name, type);
            }

            if (type.equals("Rifle")){
                gunRepository.add(new Rifle(name));
                return String.format(GUN_ADDED,name, type);
            }

            return GUN_TYPE_INVALID;
    }

    @Override
    public String addGunToPlayer(String name) {

        if (gunRepository.getModels().isEmpty()){
            return GUN_QUEUE_IS_EMPTY;
        }

        Gun gun =gunRepository.getModels().get(gunRepository.getModels().size()-1);
        if (name.equals("Vercetti")){
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER,gun.getName(),mainPlayer.getName());
        }

        for (Player civilPlayer : civilPlayerList) {
            if (civilPlayer.getName().equals(name)){
                civilPlayer.getGunRepository().add(gun);
                return String.format(GUN_ADDED_TO_CIVIL_PLAYER,name,civilPlayer.getName());
            }
        }
        return CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    @Override
    public String fight() {
        long civilsSizeBefore = civilPlayerList.size();
        neighbourhood.action(mainPlayer,civilPlayerList);
        long civilsSizeAfter = civilPlayerList.stream().filter(c -> c.getLifePoints() == 50).count();
        boolean civilsAreAllRight = civilsSizeBefore == civilsSizeAfter;
        long deadCivils = civilsSizeBefore - civilsSizeAfter;
        if (mainPlayer.getLifePoints() == 100 && civilsAreAllRight){
           return FIGHT_HOT_HAPPENED;
        }
        else {

            StringBuilder builder = new StringBuilder();
            builder.append(FIGHT_HAPPENED).append(System.lineSeparator());
            builder.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,mainPlayer.getLifePoints())).append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,deadCivils)).append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilsSizeAfter - deadCivils));
            return builder.toString();
        }
    }
}
