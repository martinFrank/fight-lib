package com.github.martinfrank.fightlib;

public class Stat {

    private StatIdentifier name;
    //private double max; // = base + modifier
    private double base;
    private double current;

    public enum Scope {BASE, CURRENT}

}
