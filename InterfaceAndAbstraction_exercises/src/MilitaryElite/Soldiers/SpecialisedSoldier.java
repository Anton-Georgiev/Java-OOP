package MilitaryElite.Soldiers;

import MilitaryElite.Corps;
import MilitaryElite.Interfaces.SpecialisedSoldierImpl;

public class SpecialisedSoldier extends Soldier implements SpecialisedSoldierImpl {
    Corps corp;

    public SpecialisedSoldier(Corps corp) {
        super();
        this.corp = corp;
    }


    @Override
    public Corps getCorp() {
        return corp;
    }
}
