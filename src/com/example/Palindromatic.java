package com.example;

import java.util.Scanner;

public class Palindromatic {

    public static void main(String[] args) {
        System.out.print("Give Me A word. I'll tell you if it's a Palindrome: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();

        while (!verifyInput(response)) {
            System.out.println("Nu uh that's not going to work. It's too short for me to check.");
            System.out.print("Give me a string of characters: ");
            response = scanner.next();
        }

        if (isPalindrome(response)) {
            System.out.println("Woah! Mind BLOWN! " + response + " IS a palindrome");
        } else {
            System.out.println("BOOOORIIINNGG! " + response + " is NOT a palindrome");
        }
    }

    private static boolean isPalindrome(String response) {
        String reverseString = convertStringToReverse(response);
        return response.equals(reverseString);
    }

    private static String convertStringToReverse(String string) {
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    private static boolean verifyInput(String response) {
        return response.length() > 1;
    }
}
