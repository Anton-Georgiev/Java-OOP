package WildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Mammal> mammals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] animalInfo = input.split("\\s+");
            String[] foodInfo = scanner.nextLine().split("\\s+");

            Food f = getFoodTypeAndQuantity(foodInfo);
            Mammal animal = getMammal(animalInfo);

            animal.makeSound();
            animal.eat(f);
            mammals.add(animal);

            input = scanner.nextLine();
        }

        mammals.forEach(System.out::println);
    }

    private static Mammal getMammal(String[] animalInfo) {
        String animalType = animalInfo[0];
        String name = animalInfo[1];
        double weight = Double.parseDouble(animalInfo[2]);
        String animalLivingRegion = animalInfo[3];

        Mammal animal = null;
        switch (animalType) {
            case "Cat":
                String breed = animalInfo[4];
                animal = new Cat(name, animalType, weight, animalLivingRegion, breed);
                break;
            case "Mouse":
                animal = new Mouse(name, animalType, weight, animalLivingRegion);
                break;
            case "Tiger":
                animal = new Tiger(name, animalType, weight, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(name, animalType, weight, animalLivingRegion);
                break;
        }

        return animal;
    }

    private static Food getFoodTypeAndQuantity(String[] foodInfo) {
        Food food;
        if (foodInfo[0].equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodInfo[1]));
        } else {
            food = new Meat(Integer.parseInt(foodInfo[1]));
        }
        return food;
    }
}