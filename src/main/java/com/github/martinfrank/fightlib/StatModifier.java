package com.github.martinfrank.fightlib;

public class StatModifier {

    private final StatIdentifier identifier;
    private final Stat.Scope scope;
    private final double amount;
    private final Kind kind;

    public StatModifier(StatIdentifier identifier, Stat.Scope scope, Kind kind, double amount) {
        this.identifier = identifier;
        this.scope = scope;
        this.kind = kind;
        this.amount = amount;
    }

    public enum Kind {INCREASE_PERCENT, INCREASE, DECREASE, DECREASE_PERCENT}

}
