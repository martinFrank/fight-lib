package com.github.martinfrank.fightlib;

import java.util.List;

public interface RuleBook {

    Chance getAttackChance(Entity attacker, Entity defender);

    Chance getDefendChance(Entity attacker, Entity defender);

    List<StatChange> getImpact(Entity attacker, Entity defender, Chance attackChance, Chance defendChance);

}
