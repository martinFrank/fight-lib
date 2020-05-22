package com.github.martinfrank.fightlib;

import java.util.Objects;

public class StatChange {

    private final Object identifier;
    private final double delta;

    public StatChange(Object identifier, double delta) {
        this.identifier = Objects.requireNonNull(identifier, "identifier must not be null");
        this.delta = delta;
    }

    public boolean matches(Stat stat) {
        return identifier.equals(stat.getIdentifier());
    }

    public double getDelta() {
        return delta;
    }

    @Override
    public String toString() {
        return "" + identifier + " delta:" + delta;
    }
}
