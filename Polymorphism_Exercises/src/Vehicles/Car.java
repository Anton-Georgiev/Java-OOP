package Vehicles;

public class Car extends Vehicle{
    private static final double AIR_CONDITIONER_ADDITIONAL_FUEL = 0.9;

    protected Car(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption + AIR_CONDITIONER_ADDITIONAL_FUEL, tankCapacity);

    }
}
