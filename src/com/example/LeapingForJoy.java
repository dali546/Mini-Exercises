package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LeapingForJoy {

    public static void main(String[] args) {
        System.out.print("I can predict all Future Leap years. How Many leap years you want? ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();

        while (!verifyInput(response)) {
            System.out.println("Nu uh that's not going to work. Try Again.");
            System.out.print("Feed me a number of leap years you want: ");
            response = scanner.next();
        }

        ArrayList<Integer> leapYears;
        int numberOfLeapYears = parseInt(response);
        LocalDate date = LocalDate.now();

        leapYears = getListOfLeapYears(numberOfLeapYears, date);
        printYears(leapYears);
    }

    private static void printYears(ArrayList<Integer> leapYears) {
        for (int year : leapYears) {
            System.out.println("This will be a Leap Year: " + year);
        }
    }

    private static ArrayList<Integer> getListOfLeapYears(int numberOfYears, LocalDate date) {
        ArrayList<Integer> years = new ArrayList<>();
        int year = date.getYear();
        while (years.size() < numberOfYears) {
            if (isYearALeapYear(year)) {
                years.add(year);
            }
            year++;
        }
        return years;
    }

    private static boolean isYearALeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else return (year % 4 == 0 && year % 100 != 0);
    }

    private static int parseInt(String response) {
        return Integer.parseInt(response);
    }

    private static boolean verifyInput(String response) {
        return response.matches("^[0-9]*") && !response.contains("-");
    }
}

