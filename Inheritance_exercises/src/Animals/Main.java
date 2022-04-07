package Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!input.equals("Beast!")) {
            String[] token = scanner.nextLine().split("\\s+");
            String name = token[0];
            int age = Integer.parseInt(token[1]);
            String gender = token[2];

            Animal animal;
            try {
                switch (input) {
                    case "Cat": animal = new Cat(name, age, gender); break;
                    case "Dog" : animal = new Dog(name, age, gender); break;
                    case "Tomcat" : animal = new Tomcat(name, age);break;
                    case "Kitten" : animal = new Kitten(name, age);break;
                    default: animal = new Frog(name, age, gender);break;
                }
                animals.add(animal);
            }
            catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
            catch (IndexOutOfBoundsException exception){
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
