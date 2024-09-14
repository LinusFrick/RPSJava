package org.rps.strategy;

import java.util.Random;

public class RandomMoveChooser implements ComputerMoveChooser {
    private Random random = new Random();

    @Override
    public int chooseMove() {
        return random.nextInt(3) + 1;
    }
}