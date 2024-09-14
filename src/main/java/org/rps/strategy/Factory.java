package org.rps.strategy;

public class Factory {

    public static ComputerMoveChooser createMoveChooser(String type) {
        if (type.equalsIgnoreCase("random")) {
            return new RandomMoveChooser();
        }
        return null;
    }
}