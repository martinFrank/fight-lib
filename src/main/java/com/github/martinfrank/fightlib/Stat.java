package com.github.martinfrank.fightlib;

public class Stat {

    private Object identifier;
    private double base;
    private double current;


    public Stat(Object identifier, double base, int current) {
        this.identifier = identifier;
        this.base = base;
        this.current = current;
    }

    public Object getIdentifier() {
        return identifier;
    }

    public void apply(StatChange change) {
        current = current + change.getDelta();
    }

    public double getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return identifier + " " + current + " / " + base;
    }

}
