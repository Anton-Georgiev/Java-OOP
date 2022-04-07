package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.Food;

public class Salad extends Food {
    private static int initialSaladPortion = 150;
    public Salad(String name, double price) {
        super(name, initialSaladPortion, price);
    }
}
