package com.example;

import java.math.BigInteger;
import java.util.Scanner;

public class RabbitFrenzy {

    public static void main(String[] args) {
        System.out.print("Fibonacci. Watch the numbers just Multiply... How many Numbers do you want: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();

        BigInteger a,b;
        a = BigInteger.valueOf(0);
        b = BigInteger.valueOf(1);

        while (!verifyInput(response)) {
            System.out.println("Nu uh that's not going to work. I need a Number: ");
            System.out.print("Give me a number: ");
            response = scanner.next();
        }

        int number = Integer.parseInt(response);
        printNumber(a);
        printNumber(b);
        for (int i = 0; i < number; i++) {
            BigInteger nextInt = calculateNextFibonacciNumber(a, b);
            //printNumber(nextInt);
            a=b;
            b=nextInt;
        }
        System.out.println(calculateNextFibonacciNumber(a,b).toString().length());
    }

    private static void printNumber(BigInteger number) {
        System.out.println("Fibonacci Number: " + number);
    }

    private static BigInteger calculateNextFibonacciNumber(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    private static boolean verifyInput(String response) {
        return response.matches("^[0-9]*") && !response.contains("-");
    }
}

