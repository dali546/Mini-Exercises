package com.example;

import java.util.Scanner;

public class Greetings {

    public static void main(String[] args) {
	    System.out.println("Greetings. Who Are You? ");

        Scanner scanner = new Scanner(System.in);
	    String name = scanner.next();
        welcomeUser(name);

    }

    private static void welcomeUser(String name) {
        if (verifyUser(name)){
            System.out.println("Well Hello there, " + name);
        } else {
            System.out.println("You shall not pass, " + name);
        }
    }

    private static boolean verifyUser(String name) {
        return name.equals("Alice") || name.equals("Bob");
    }

}
