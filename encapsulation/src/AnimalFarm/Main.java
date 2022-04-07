package AnimalFarm;

import AnimalFarm.Chicken;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         String chickenName = scanner.nextLine();
         int age = Integer.parseInt(scanner.nextLine());
         Chicken chick = new Chicken(chickenName,age);
        System.out.println(chick.toString());

    }
}
