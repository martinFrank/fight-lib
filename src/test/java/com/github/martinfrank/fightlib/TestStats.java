package com.github.martinfrank.fightlib;

import java.util.ArrayList;
import java.util.List;

public class TestStats implements Stats {

    private final List<Stat> collection;

    public TestStats() {
        collection = new ArrayList<>();
        collection.add(new Stat(TestStatIdentifier.HEALTH, 1, 1));
    }

    @Override
    public Stat getStat(Object identifier) {
        return collection.stream().filter(s -> s.getIdentifier().equals(identifier)).findAny().orElse(null);
    }

    @Override
    public void changeStats(List<StatChange> impact) {
        for (Stat stat : collection) {
            for (StatChange change : impact) {
                if (change.matches(stat)) {
                    stat.apply(change);
                }
            }
        }

    }
}
