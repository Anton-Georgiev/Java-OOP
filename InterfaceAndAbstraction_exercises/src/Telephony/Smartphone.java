package Telephony;

import Telephony.Interfaces.Browsable;
import Telephony.Interfaces.Callable;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    List<String> numbers;
    List<String> urls;

    public Smartphone(List<String> nums ,List<String> urls){
        this.numbers = nums;
        this.urls = urls;
    }
    @Override
    public String browse() {
        StringBuilder out = new StringBuilder();

        for (String url : urls) {
            char[] charUrl = url.toCharArray();
            boolean hasNoDigit = true;
            for (char c : charUrl) {
                if (Character.isDigit(c)){
                    out.append("Invalid URL!\n");
                    hasNoDigit = false;
                    break;
                } else hasNoDigit = true;
            }if (hasNoDigit){
                out.append("Browsing: " + url + "!\n");
            }
        }
        return out.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder out = new StringBuilder();
        for (String number : numbers) {
            if (number.matches("\\d+")){
                out.append("Calling... " + number + "\n");
            } else {
                out.append("Invalid number!\n");
            }
        }
        return out.toString();
    }
}
