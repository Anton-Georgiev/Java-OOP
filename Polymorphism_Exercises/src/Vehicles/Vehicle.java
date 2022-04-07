package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuel;
    protected double consumption;
    protected double tankCapacity;


    protected Vehicle(double fuel, double consumption, double tankCapacity){
        this.fuel = fuel;
        this.consumption =consumption;
        this.tankCapacity = tankCapacity;
    }

    private void setFuel(double fuel){
        if (fuel< 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (fuel > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuel = fuel;
    }

    @Override
        public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuel);
    }


    protected String drive(double distance) {
        if (fuel >= distance * this.consumption){
            this.fuel -= consumption* distance;

            if (fuel <=0){
                System.out.println("Fuel must be a positive number");
            }

            DecimalFormat formatter = new DecimalFormat("#.##");
            return String.format( this.getClass().getSimpleName() + " travelled %s km", formatter.format(distance));
        }
        else  return String.format("%s needs refueling", this.getClass().getSimpleName());
    }


    protected  void refuel(double liters) {

        if (liters <= 0){
            System.out.println("Fuel must be a positive number");
            return;
        }
        if (fuel + liters <= tankCapacity){
            this.fuel += liters;
        } else System.out.println("Cannot fit fuel in tank");
    }
}
