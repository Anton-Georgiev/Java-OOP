package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import static restaurant.common.ExceptionMessages.*;

public abstract class Food implements HealthyFood {
    private String name;
    private double portion;
    private double price;

    public Food(String name, double portion, double price) {
        setName(name);
        SetPortion(portion);
        setPrice(price);
    }

    private void setPrice(double price) {
        if (price<= 0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    private void SetPortion(double portion) {
        if (portion<= 0){
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setName(String name) {
        if (name== null|| name.equals(" ")){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
