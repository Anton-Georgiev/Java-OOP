package Restaurant.Beverage;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{
    double COFFEE_MILLILITERS = 50;
    BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    double caffeine;
    public Coffee(String name, BigDecimal price, double milliliters,double caffeine) {
        super(name, price, milliliters);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
