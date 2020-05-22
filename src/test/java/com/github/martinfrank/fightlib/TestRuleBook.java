package com.github.martinfrank.fightlib;

import java.util.Collections;
import java.util.List;

public class TestRuleBook implements RuleBook {

    @Override
    public Chance getAttackChance(Entity attacker, Entity defender) {
        return new WinningChance();
    }

    @Override
    public Chance getDefendChance(Entity attacker, Entity defender) {
        return new FailingChance();
    }

    @Override
    public List<StatChange> getImpact(Entity attacker, Entity defender, Chance attackChance, Chance defendChance) {
        return Collections.singletonList(new StatChange(TestStatIdentifier.HEALTH, -1));
    }
}
