package com.github.martinfrank.fightlib;

public class TestEntity implements Entity {

    private final String name;
    private final Chance attackChance;
    private final Chance defendChance;

    public TestEntity(String name, Chance attackChance, Chance defendChance) {
        this.name = name;
        this.attackChance = attackChance;
        this.defendChance = defendChance;
    }

    @Override
    public Chance getAttackChance(Entity defender) {
        return attackChance;
    }

    @Override
    public Chance getDefendChance(Entity attacker) {
        return defendChance;
    }

    @Override
    public Damage getDamage(Entity defender) {
        return new TestDamage();
    }

    @Override
    public void applyDamage(Damage damage) {

    }

    @Override
    public String toString() {
        return name;
    }
}
