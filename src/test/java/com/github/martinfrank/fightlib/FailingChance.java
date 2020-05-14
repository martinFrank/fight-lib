package com.github.martinfrank.fightlib;

import java.util.Random;

public class FailingChance implements Chance {

    private final Random random = new Random();
    private int die;
    private boolean rolled = false;

    @Override
    public void roll() {
        if (!rolled) {
            die = 1 + random.nextInt(20);
            rolled = true;
        }
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
