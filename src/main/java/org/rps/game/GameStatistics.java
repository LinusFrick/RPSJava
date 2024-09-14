package org.rps.game;

public class GameStatistics {
    private static GameStatistics instance;
    private String playerName;
    private int playerWins;
    private int computerWins;
    private int totalGames;

    private GameStatistics() {
        playerWins = 0;
        computerWins = 0;
        totalGames = 0;
    }

    public static GameStatistics getInstance() {
        if (instance == null) {
            instance = new GameStatistics();
        }
        return instance;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void incrementPlayerWins() {
        playerWins++;
    }

    public void incrementComputerWins() {
        computerWins++;
    }

    public void incrementTotalGames() {
        totalGames++;
    }

    public void printStatistics() {
        System.out.println("Spelare: " + playerName + " - Vinster: " + playerWins);
        System.out.println("Datorn - Vinster: " + computerWins);
        System.out.println("Totala matcher spelade: " + totalGames);
    }
}