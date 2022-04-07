package MilitaryElite.Soldiers;

import MilitaryElite.Corps;
import MilitaryElite.Interfaces.CommandoImpl;
import MilitaryElite.Mission;

import java.util.Collection;
import java.util.Set;

public class Commando extends SpecialisedSoldier implements CommandoImpl {
    Set<Mission> missions;

    public Commando(Corps corp) {
        super(corp);

    }

    public void AddMission(Mission mission){
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMission() {
        return missions;
    }
}
