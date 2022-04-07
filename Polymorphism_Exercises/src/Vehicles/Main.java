package Vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);


        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("Car", createVehicle(scr.nextLine()));
        vehicleMap.put("Truck", createVehicle(scr.nextLine()));
        Bus bus = createBus(scr.nextLine());
        vehicleMap.put("Bus", bus);

        // Bus bus = createBus(scr.nextLine());
        int commandNum = Integer.parseInt(scr.nextLine());
        System.out.println();
        while (commandNum-- > 0) {
            String input = scr.nextLine();
                String[] commands = input.split("\\s+");
            double argument = Double.parseDouble(commands[2]);

            if (commands[0].contains("Drive")) {
                if (commands[1].equals("Car")) {
                    System.out.println(vehicleMap.get("Car").drive(argument));
                } else if (commands[1].equals("Bus")) {
                    if (commands[0].contains("Empty")) {
                        System.out.println(vehicleMap.get("Bus").drive(argument));
                    } else {
                        bus.setWithPeople();
                        System.out.println(vehicleMap.get("Bus").drive(argument));
                    }
                } else {
                    System.out.println(vehicleMap.get("Truck").drive(argument));
                }
            } else {
                if (commands[1].equals("Car")) {
                    vehicleMap.get("Car").refuel(argument);
                } else {
                    vehicleMap.get("Truck").refuel(argument);
                }
            }
        }
        vehicleMap.forEach((k,v) -> System.out.println(v.toString()));
    }
    private static Bus createBus(String nextLine) {
        String[] input = nextLine.split(" ");
        return new Bus(Double.parseDouble(input[1]),
                Double.parseDouble(input[2]),
                Double.parseDouble(input[3]));
    }


    private static Vehicle createVehicle(String nextLine) {
        String[] input = nextLine.split(" ");
        switch (input[0]){
            case "Car":  return new Car(Double.parseDouble(input[1]),
                    Double.parseDouble(input[2]),
                    Double.parseDouble(input[3]));

            case "Truck": return new Truck(Double.parseDouble(input[1]),
                    Double.parseDouble(input[2]),
                    Double.parseDouble(input[3]));

            case "Bus":createBus(nextLine);
            default: throw  new IllegalStateException("Unknown vehicle for type " + input[0]);
        }
    }
}
