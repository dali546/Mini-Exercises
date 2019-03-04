package com.example;

import java.util.*;

public class Akinator {

    private static final String INVALID_NUMBER_TRY_AGAIN = "Invalid Number. Try Again.";
    private static final String GUESS = "Take a Guess of my number: ";
    private static final String TOO_LOW = "Nah, Too Low. Try Again.";
    private static final String TOO_HIGH = "Oof, Too High. Try Again";

    public static void main(String[] args) {
        printStartMessage();
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        response = getValidInput(scanner, response, "Invalid Option. Try Again.", "Enter an Option: ");
        int option = parseInt(response);
        loadOption(scanner, option);
    }

    private static void loadOption(Scanner scanner, int option) {
        if (option == 1) {
            gameOne(scanner);
        } else if (option == 2) {
            gameTwo(scanner);
        } else if (option == 3) {
            gameThree(scanner);
        } else {
            print("Invalid Option. Game Exiting...");
        }
    }

    private static void gameThree(Scanner scanner) {
        boolean lie = false;
        int i = new Random().nextInt(100);
        int playerGuess = 0;
        print("Ok I've got a number. Guess:");
        String response = scanner.next();
        if (!response.equals("lie")) playerGuess = getPlayerGuess(scanner, response);

        while (!response.equals("lie") && (playerGuess != i || lie)) {
            lie = new Random().nextFloat() < 0.25;
            if (playerGuess > i) {
                print(lie ? TOO_LOW : TOO_HIGH);
                response = scanner.next();
                if (!response.equals("lie")) playerGuess = getPlayerGuess(scanner, response);
            } else {
                print(lie ? TOO_HIGH : TOO_LOW);
                response = scanner.next();
                if (!response.equals("lie")) playerGuess = getPlayerGuess(scanner, response);
            }
        }


        if (playerGuess == i) print("Congrats. You got it right");
        else print(lie ? "You Caught Me out. Nice." : "No! I was telling the truth. Game Over");
    }

    private static void gameTwo(Scanner scanner) {
        print("Respond with either");
        print("1. Too High");
        print("2. Too Low");
        print("3. Correct");
        print("Ok Think of s number (1-100). I'll Guess: ");
        int previousGuess;
        int playerResponse = 0;
        int guess;
        int lb = 0;
        int ub = 100;
        while (playerResponse != 3) {
            guess = generateNumber(lb, ub);
            print("Is your number " + guess + "?");
            String response = scanner.next();
            playerResponse = getPlayerGuess(scanner, response);
            previousGuess = guess;

            if (playerResponse == 1) {
                ub = previousGuess;
            } else if (playerResponse == 2) {
                lb = previousGuess;
            }

        }
        print("Yay I won");
    }

    private static int generateNumber(int lb, int ub) {
        return lb + ((ub + 1 -lb)/2);
    }

    private static void gameOne(Scanner scanner) {
        int i = new Random().nextInt(100);
        print("Ok I've got a number. Guess:");
        int playerGuess;

        do {
            String response = scanner.next();
            playerGuess= getPlayerGuess(scanner, response);
            print(playerGuess > i ? TOO_HIGH : TOO_LOW);
        } while (playerGuess!=i);


        print("You Won. Go You!");
    }

    private static int getPlayerGuess(Scanner scanner, String response) {
        int playerGuess;
        response = getValidInput(scanner, response, INVALID_NUMBER_TRY_AGAIN, GUESS);
        playerGuess = parseInt(response);
        return playerGuess;
    }


    private static void print(String s) {
        System.out.println(s);
    }

    private static int parseInt(String response) {
        return Integer.parseInt(response);
    }

    private static void printStartMessage() {
        print("I want to Play a Game...");
        print("1. Guess what number I'm thinking");
        print("2. I will read your mind. You think of a number");
        print("3. Guess What Number I'm thinking... I can lie...");
        System.out.print("Enter Option: ");
    }

    private static String getValidInput(Scanner scanner, String response, String errMessage, String instruction) {
        while (!response.matches("^[0-9]*") && !response.contains("-")) {
            print(errMessage);
            System.out.print(instruction);
            response = scanner.next();
        }
        return response;
    }

}
