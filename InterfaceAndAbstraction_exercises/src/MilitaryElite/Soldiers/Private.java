package MilitaryElite.Soldiers;

import MilitaryElite.Interfaces.PrivateImpl;

public class Private extends Soldier implements PrivateImpl {
    double salary;
     public Private(int id, String firstName, String lastName, double salary){
         super(id,firstName,lastName);
         this.salary = salary;
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
    public double getSalary() {
        return salary;
    }
}
