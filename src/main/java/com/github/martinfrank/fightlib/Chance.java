package com.github.martinfrank.fightlib;

public interface Chance {

    void roll();

    boolean wasSuccessful();

    String getRollResult();
}
