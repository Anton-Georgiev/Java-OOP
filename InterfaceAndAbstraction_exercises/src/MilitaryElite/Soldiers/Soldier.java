package MilitaryElite.Soldiers;

import MilitaryElite.Interfaces.SoldierImpl;

public abstract class Soldier implements SoldierImpl {
    int id;
    String firstName;
    String lastName;

    public Soldier(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
