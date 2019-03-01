package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boomerang {

    public static void main(String[] args) {
        System.out.print("I'm a boomerang. Feed me a number. Say 'done' when you're done: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        while (!response.equals("done")) {
            while (!verifyInput(response)) {
                System.out.println("Nu uh that's not going to work. Try Again.");
                System.out.print("Feed me a number: ");
                response = scanner.next();
            }
            addToList(response, listOfNumbers);
            System.out.print("Feed me another number (or type 'done'): ");
            response = scanner.next();
        }

        printResponse(listOfNumbers);
    }

    private static void printResponse(ArrayList<Integer> listOfNumbers) {
        Collections.reverse(listOfNumbers);
        System.out.println("Here comes the Boomerang...");
        for (int i: listOfNumbers){
            System.out.println(i);
        }
    }

    private static void addToList(String response, ArrayList<Integer> listOfNumbers) {
        int i = Integer.parseInt(response);
        listOfNumbers.add(i);
    }

    private static boolean verifyInput(String response) {
        return response.matches("^[0-9]*") && !response.contains("-");
    }
}
