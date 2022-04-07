package Telephony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String[] phoneNums = scr.nextLine().split("\\s+");
        String[] urls = scr.nextLine().split("\\s+");

        List<String> phoneNumbersList = new ArrayList<String>(Arrays.asList(phoneNums));
        List<String> urlList = new ArrayList<String>(Arrays.asList(urls));

        Smartphone phone = new Smartphone(phoneNumbersList,urlList);
        System.out.print(phone.call());
        System.out.print(phone.browse());


    }
}
