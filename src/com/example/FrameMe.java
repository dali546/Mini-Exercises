package com.example;

import java.util.*;

public class FrameMe {
    public static void main(String[] args) {
        System.out.print("You've been Framed. I will border a picture with a character of your choice.");
        System.out.print("Please enter the text you want Framed: ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        while (verifyInput(response)) {
            System.out.println("Nu uh that's not going to work. I need a long string: ");
            System.out.print("Give me a String: ");
            response = scanner.next();
        }
        System.out.print("Enter a char to frame your picture with: ");
        String border = scanner.nextLine();
        while (verifyInput(border)) {
            System.out.println("Nu uh that's not going to work. I need a single character: ");
            System.out.print("Give me a single Character: ");
            border = scanner.next();
        }
        List<String> strings = splitString(response);
        printFrame(border, strings);
    }

    private static void printFrame(String border, List<String> strings) {
        String longestWord = calculateLongestWord(strings);
        String borderRepeat = border.repeat(4 + longestWord.length());
        System.out.println(borderRepeat);
        for (String s : strings) {
            String spaceRepeat = " ".repeat((2 + longestWord.length() - s.length()) / 2);
            System.out.println(border + (isStringEven(s) ? spaceRepeat : spaceRepeat + " ") + s + spaceRepeat + border);
        }
        System.out.println(borderRepeat);
    }

    private static boolean isStringEven(String s) {
        return s.length() % 2 == 0;
    }

    private static String calculateLongestWord(List<String> strings) {
        return Collections.max(strings, Comparator.comparing(String::length));

    }

    private static List<String> splitString(String response) {
        return Arrays.asList(response.split(" "));
    }

    private static boolean verifyInput(String response) {
        return response.length() < 1;
    }
}