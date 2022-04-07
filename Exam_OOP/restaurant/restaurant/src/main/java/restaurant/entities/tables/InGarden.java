package restaurant.entities.tables;

import restaurant.entities.drinks.BaseBeverage;

public class InGarden extends BaseTable {
    private static final double pricePerPerson = 4.50;

    public InGarden(int number, int size) {
        super(number, size, pricePerPerson);
    }
}
