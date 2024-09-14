package org.rps.strategy;

public class Decorator implements ComputerMoveChooser {
    private ComputerMoveChooser decoratedStrategy;
    private int lastMove = -1;

    public Decorator(ComputerMoveChooser strategy) {
        this.decoratedStrategy = strategy;
    }

    @Override
    public int chooseMove() {
        int move;
        do {
            move = decoratedStrategy.chooseMove();
        } while (move == lastMove);
        lastMove = move;
        return move;
    }
}