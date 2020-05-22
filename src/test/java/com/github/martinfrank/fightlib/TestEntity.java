package com.github.martinfrank.fightlib;

public class TestEntity implements Entity {

    private final String name;
    private final Stats stats = new TestStats();

    public TestEntity(String name) {
        this.name = name;
    }

    @Override
    public Stats getStats() {
        return stats;
    }


    @Override
    public String toString() {
        return name;
    }
}
