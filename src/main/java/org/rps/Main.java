package org.rps;

import org.rps.builder.GameBuilder;
import org.rps.player.Player;
import org.rps.strategy.ComputerMoveChooser;
import org.rps.strategy.Factory;
import org.rps.game.GameStatistics;
import org.rps.game.Game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Player player = null;
        GameStatistics statistics = GameStatistics.getInstance();

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
                    String playerName = scanner.nextLine();
                    player = new Player(playerName);
                    statistics.setPlayerName(playerName);
                    System.out.println("Hej " + playerName + ", du kan nu starta spelet.");
                    break;
                case 2:
                    if (player == null) {
                        System.out.println("Du måste ange ditt namn innan du kan starta spelet.");
                    } else {
                        System.out.print("Ange antal rundor för att vinna: ");
                        int roundsToWin = scanner.nextInt();
                        scanner.nextLine(); // Konsumera newline-tecknet

                        ComputerMoveChooser strategy = Factory.createMoveChooser("random");

                        Game game = new GameBuilder()
                                .withPlayer(player)
                                .withStrategy(strategy)
                                .withRoundsToWin(roundsToWin)
                                .build();

                        game.startGame(scanner);
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
}