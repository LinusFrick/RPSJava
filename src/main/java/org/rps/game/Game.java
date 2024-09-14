package org.rps.game;

import org.rps.player.Player;
import org.rps.strategy.ComputerMoveChooser;
import java.util.Scanner;

public class Game {
    private Player player;
    private ComputerMoveChooser computerMoveChooser;
    private int roundsToWin;
    private GameStatistics statistics = GameStatistics.getInstance();

    public Game(Player player, ComputerMoveChooser computerMoveChooser, int roundsToWin) {
        this.player = player;
        this.computerMoveChooser = computerMoveChooser;
        this.roundsToWin = roundsToWin;
        statistics.incrementTotalGames();
    }

    public void startGame(Scanner scanner) {
        int computerScore = 0;
        player.resetScore();

        System.out.println("Spelet börjar nu. Först till " + roundsToWin + " vinster!");

        while (player.getScore() < roundsToWin && computerScore < roundsToWin) {
            System.out.println("\nVälj: 1 för Sten, 2 för Sax, 3 för Påse");
            int playerChoice = scanner.nextInt();
            while (playerChoice < 1 || playerChoice > 3) {
                System.out.println("Ogiltigt val, välj igen: 1 för Sten, 2 för Sax, 3 för Påse");
                playerChoice = scanner.nextInt();
            }

            int computerChoice = computerMoveChooser.chooseMove();

            String[] moves = {"Sten", "Sax", "Påse"};
            System.out.println("Datorn valde: " + moves[computerChoice - 1]);

            if (playerChoice == computerChoice) {
                System.out.println("Oavgjort!");
            } else if ((playerChoice == 1 && computerChoice == 2) ||
                    (playerChoice == 2 && computerChoice == 3) ||
                    (playerChoice == 3 && computerChoice == 1)) {
                System.out.println(player.getName() + " vinner denna omgång!");
                player.incrementScore();
            } else {
                System.out.println("Datorn vinner denna omgång!");
                computerScore++;
            }

            System.out.println(player.getName() + ": " + player.getScore() + " - Datorn: " + computerScore);
        }

        if (player.getScore() == roundsToWin) {
            System.out.println("\nGrattis! " + player.getName() + " vann spelet!");
            statistics.incrementPlayerWins();
        } else {
            System.out.println("\nDatorn vann spelet!");
            statistics.incrementComputerWins();
        }

        statistics.printStatistics();
    }
}