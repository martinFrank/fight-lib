package com.github.martinfrank.fightlib;

import java.util.Random;

public class WinningChance implements Chance {

    private final int die;

    public WinningChance() {
        die = 1 + new Random().nextInt(20);
    }

    @Override
    public boolean wasSuccessful() {
        return die < 23;
    }

    @Override
    public String getRollResult() {
        return "1D20=" + die;
    }

    @Override
    public String toString() {
        return "succeed if 1D20 < 23";
    }
}
