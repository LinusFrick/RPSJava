package org.rps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Välkommen till Sten-Sax-Påse!");
            System.out.println("1. Starta nytt spel");
            System.out.println("2. Avsluta");
            System.out.print("Ange val: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nytt spel startas...");
                    break;
                case 2:
                    System.out.println("Avslutar...");
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        scanner.close();
    }
}
