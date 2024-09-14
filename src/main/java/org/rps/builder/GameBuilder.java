package org.rps.builder;

import org.rps.game.Game;
import org.rps.player.Player;
import org.rps.strategy.ComputerMoveChooser;

public class GameBuilder {
    private Player player;
    private ComputerMoveChooser strategy;
    private int roundsToWin;

    public GameBuilder withPlayer(Player player) {
        this.player = player;
        return this;
    }

    public GameBuilder withStrategy(ComputerMoveChooser strategy) {
        this.strategy = strategy;
        return this;
    }

    public GameBuilder withRoundsToWin(int rounds) {
        this.roundsToWin = rounds;
        return this;
    }

    public Game build() {
        return new Game(player, strategy, roundsToWin);
    }
}
