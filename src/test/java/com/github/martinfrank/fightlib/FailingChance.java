package com.github.martinfrank.fightlib;

import java.util.Random;

public class FailingChance implements Chance {

    private final int die;

    public FailingChance() {
        die = 1 + new Random().nextInt(20);
    }

    @Override
    public boolean wasSuccessful() {
        return die < 0;
    }

    @Override
    public String getRollResult() {
        return "1D20=" + die;
    }

    @Override
    public String toString() {
        return "succeed if 1D20 < 0";
    }
}
