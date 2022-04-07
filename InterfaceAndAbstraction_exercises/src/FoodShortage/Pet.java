package FoodShortage;

import FoodShortage.Interfaces.Birthable;

public class Pet implements Birthable {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate){
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName(){
        return name;
    }


    @Override
    public String getBirthDate() {
        return birthdate;
    }
}
