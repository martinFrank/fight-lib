package com.github.martinfrank.fightlib;

public class TestEntity implements Entity {

    private final String name;
    private final Stats stats = new TestStats();
    private boolean isSupposedToSucceedInAttack;
    private boolean isSupposedToSucceedInDefense;

    public TestEntity(String name) {
        this.name = name;
    }

    @Override
    public Stats getStats() {
        return stats;
    }


    @Override
    public String toString() {
        return name + " " + getStats().getStat(TestStatIdentifier.HEALTH);
    }

    public boolean isSupposedToSucceedInAttack() {
        return isSupposedToSucceedInAttack;
    }

    public void setSupposedToSucceedInAttack(boolean supposedToSucceedInAttack) {
        isSupposedToSucceedInAttack = supposedToSucceedInAttack;
    }

    public boolean isSupposedToSucceedInDefense() {
        return isSupposedToSucceedInDefense;
    }

    public void setSupposedToSucceedInDefense(boolean supposedToSucceedInDefense) {
        isSupposedToSucceedInDefense = supposedToSucceedInDefense;
    }
}
