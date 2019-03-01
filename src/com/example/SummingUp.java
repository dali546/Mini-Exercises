package com.example;

import java.util.Scanner;

public class SummingUp {

    public static void main(String[] args) {
        System.out.print("I am the Ultimate Adder. Feed me a number: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();

        while (!verifyInput(response)) {
            System.out.println("Nu uh that's not going to work. Try Again.");
            System.out.print("I am the Ultimate Adder. Feed me a number: ");
            response = scanner.next();
        }
        respondToConsole(response);
    }

    private static boolean verifyInput(String response) {
        if (!response.matches("^[0-9]*") || response.contains("-")) {
            return false;
        } else {
            return true;
        }
    }

    private static void respondToConsole(String response) {
        int number = Integer.parseInt(response);
        System.out.println("I've done my thinking... All the number from 0 to " + number + ", sum to " + countToNumber(number));
        System.out.println("I'm a clever little program aren't I?");
    }

    private static int countToNumber(int number) {
        int ans = 0;
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                ans += i;
            }
        }
        return ans;
    }
}

