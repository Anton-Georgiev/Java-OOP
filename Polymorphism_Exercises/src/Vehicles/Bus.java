package Vehicles;

public class Bus extends Vehicle{
    private static double AIR_CONDITIONER_CONSUMPTION = 0;
    private static boolean withPeople = false;
    public Bus(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption ,tankCapacity);
    }

    public void setWithPeople() {
        withPeople = true;
        AIR_CONDITIONER_CONSUMPTION = 1.4;
        super.consumption += AIR_CONDITIONER_CONSUMPTION;
        //setConsumption(getConsumption() + AIR_CONDITIONER_CONSUMPTION);

    }

}
