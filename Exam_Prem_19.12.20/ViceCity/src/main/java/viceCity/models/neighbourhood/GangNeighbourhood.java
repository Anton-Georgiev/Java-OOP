package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {
    public GangNeighbourhood(){

    }
    @Override
    public void action(Player mainPlayer, List<Player> civilPlayers) {

        int civilsSize = civilPlayers.size();

        for (int i = 0; i < civilsSize; i++) {
            List<Gun> mainPlayerGuns = new ArrayList<>(mainPlayer.getGunRepository().getModels());
            CivilPlayer currCivil = (CivilPlayer) civilPlayers.get(i);

            while (mainPlayer.isAlive() && !mainPlayerGuns.isEmpty()) {
                for (Gun currMainPlayerGun : mainPlayerGuns) {

                    if (currMainPlayerGun.getBulletsPerBarrel() == 0 && currMainPlayerGun.getTotalBullets() == 0) {
                        continue;
                    }

                    if (!currCivil.isAlive()) {
                        civilPlayers.remove(currCivil);
                        break;
                    }

                    int pointsToTake = currMainPlayerGun.fire();
                    currCivil.takeLifePoints(pointsToTake);
                }
                if (!currCivil.isAlive()) {
                    break;
                }
            }
            if (!currCivil.isAlive()) {
                break;
            }
        }


        for (Player currCivilPlayer : civilPlayers) {
           List<Gun> currCivilPlayerGunList = new ArrayList<>(currCivilPlayer.getGunRepository().getModels());
            for (Gun gun : currCivilPlayerGunList) {

                if (gun.canFire()){

                    mainPlayer.takeLifePoints(gun.fire());
                    if (!mainPlayer.isAlive()){
                        break;
                    }
                }
                if (!mainPlayer.isAlive()){
                    break;
                }
            }
            if (!mainPlayer.isAlive()){
                break;
            }
        }
    }
}
