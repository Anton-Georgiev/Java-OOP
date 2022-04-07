package bakery.entities.bakedFoods;

public class Bread extends BaseFood {
    private static final double initPortion = 200;

    public Bread(String name, double price) {
        super(name, initPortion, price);
    }
}
