package org.rps;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;
        String playerName = "";
        int roundsToWin = 0;

        while (running) {
            System.out.println("Sten-Sax-Påse!");
            System.out.println("1. Ange ditt namn");
            System.out.println("2. Starta nytt spel");
            System.out.println("3. Avsluta");
            System.out.print("Ange val: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ange ditt namn: ");
                    playerName = scanner.nextLine();
                    System.out.println("Hej " + playerName + ", du kan nu starta spelet.");
                    break;
                case 2:
                    if (playerName.isEmpty()) {
                        System.out.println("Du måste ange ett namn innan du kan starta spelet :).");
                    } else {
                        System.out.print("Ange antal rundor för att vinna: ");
                        roundsToWin = scanner.nextInt();
                        startGame(scanner, random, playerName, roundsToWin);
                    }
                    break;
                case 3:
                    System.out.println("Avslutar");
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }

        scanner.close();
    }

    public static void startGame(Scanner scanner, Random random, String playerName, int roundsToWin) {
        int playerScore = 0;
        int computerScore = 0;

        while (playerScore < roundsToWin && computerScore < roundsToWin) {
            System.out.println("\nVälj: 1 för Sten, 2 för Sax, 3 för Påse");
            int playerChoice = scanner.nextInt();
            int computerChoice = random.nextInt(3) + 1;

            if (playerChoice == computerChoice) {
                System.out.println("Oavgjort!");
            } else if ((playerChoice == 1 && computerChoice == 2) ||
                    (playerChoice == 2 && computerChoice == 3) ||
                    (playerChoice == 3 && computerChoice == 1)) {
                System.out.println("Du vinner denna omgång!");
                playerScore++;
            } else {
                System.out.println("Datorn vinner denna omgång!");
                computerScore++;
            }

            System.out.println(playerName + ": " + playerScore + " - Datorn: " + computerScore);
        }

        if (playerScore == roundsToWin) {
            System.out.println("\nGrattis! Du vann spelet!");
        } else {
            System.out.println("\nDatorn vann spelet!");
        }
    }
}