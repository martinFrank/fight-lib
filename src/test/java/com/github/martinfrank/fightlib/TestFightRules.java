package com.github.martinfrank.fightlib;

import java.util.Collections;
import java.util.List;

public class TestFightRules implements FightRules<Chance, TestEntity> {

    @Override
    public Chance getAttackChance(TestEntity attacker, TestEntity defender) {
        if (attacker.isSupposedToSucceedInAttack()) {
            return new WinningChance();
        }
        return new FailingChance();
    }

    @Override
    public Chance getDefendChance(TestEntity attacker, TestEntity defender) {
        if (defender.isSupposedToSucceedInDefense()) {
            return new WinningChance();
        }
        return new FailingChance();
    }

    @Override
    public List<StatChange> getImpact(TestEntity attacker, TestEntity defender, Chance attackChance, Chance defendChance) {
        return Collections.singletonList(new StatChange(TestStatIdentifier.HEALTH, -1));
    }
}
