package FoodShortage;

import FoodShortage.Interfaces.Buyer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int num = Integer.parseInt(scr.nextLine());
        String command = scr.nextLine();

        Map<String, Buyer> map = new HashMap<>();
        while (num-->0){
            String[] token = command.split(" ");
            switch (token.length) {
                case 4:
                    map.putIfAbsent(token[0], new Citizen(token[0], Integer.parseInt(token[1]), token[2], token[3]));
                    break;
                case 3:
                    map.putIfAbsent(token[0], new Rebel(token[0], Integer.parseInt(token[1]), token[2]));
                    break;
            }
            command = scr.nextLine();
        }
            while (!command.equalsIgnoreCase("end")){
                if (map.containsKey(command)){
                    map.get(command).buyFood();
                }
                command = scr.nextLine();
            }
            int output=0;
        for (Buyer buyer : map.values()) {
            output += buyer.getFood();
        }
        System.out.println(output);
    }
}
