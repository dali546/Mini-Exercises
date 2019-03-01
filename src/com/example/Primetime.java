package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Primetime {

    public static void main(String[] args) {
        System.out.print("I will give you a list of Prime Numbers. How many do you want: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();

        while (!verifyInput(response)) {
            System.out.println("Nu uh that's not going to work. Try Again.");
            System.out.print("Feed me a number so I can give you that many Special Numbers: ");
            response = scanner.next();
        }

        ArrayList<Integer> listOfPrime;
        int number = Integer.parseInt(response);
        listOfPrime = getListOfPrimeNumbers(number);


        printNumbers(listOfPrime);
    }

    private static void printNumbers(ArrayList<Integer> primeNumbers) {
        for (int number : primeNumbers) {
            System.out.println("This is a Prime Number: " + number);
        }
    }

    private static ArrayList<Integer> getListOfPrimeNumbers(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; list.size() < number; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isPrime(int number) {
        for (int test = 2; test < number; test++) {
            if (number % test == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean verifyInput(String response) {
        return response.matches("^[0-9]*") && !response.contains("-");
    }

}

