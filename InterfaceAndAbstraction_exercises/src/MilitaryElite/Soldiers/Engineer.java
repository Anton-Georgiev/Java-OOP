package MilitaryElite.Soldiers;

import MilitaryElite.Corps;
import MilitaryElite.Interfaces.EngineerImpl;
import MilitaryElite.Repair;

import java.util.Collection;
import java.util.Set;

public class Engineer extends SpecialisedSoldier implements EngineerImpl {
    Set<Repair> repairSet;

    public Engineer(Corps corp, Set<Repair> repairSet) {
        super(corp);
        this.repairSet = repairSet;
    }

    public void addRepair(Repair repair){
        repairSet.add(repair);
    }
@Override
    public Collection<Repair> getRepairs(){
        return repairSet;
    }

}
