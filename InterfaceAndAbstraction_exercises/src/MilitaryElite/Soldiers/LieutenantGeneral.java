package MilitaryElite.Soldiers;

import MilitaryElite.Interfaces.LieutenantImpl;


import java.util.Arrays;
import java.util.Set;

public class LieutenantGeneral extends Soldier implements LieutenantImpl {
    Set<Private> privates;
    public LieutenantGeneral(int id, String firstName, String lastName, int... privateIds) {
        super(id, firstName, lastName);
        for (int privateId : privateIds) {
            privates.add()
        }
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public Set<Private> getPrivates() {
        return privates;
    }
}
