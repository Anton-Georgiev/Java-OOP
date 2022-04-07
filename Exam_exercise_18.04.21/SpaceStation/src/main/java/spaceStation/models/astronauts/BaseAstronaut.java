package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import java.util.Collection;
import java.util.List;

import static spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut{
    private String name;
    private double oxygen;
    private Bag bag;
    protected static int units = 10;

    protected BaseAstronaut(String name, double oxygen){
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setOxygen(double oxygen) {
        if (oxygen <0){
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    private void setName(String name) {
        if (name == null || name.equals("\\s+")){
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        setOxygen(this.oxygen-units);
    }
}
