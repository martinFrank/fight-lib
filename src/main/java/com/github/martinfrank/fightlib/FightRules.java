package com.github.martinfrank.fightlib;

import java.util.List;

public interface FightRules<I extends Chance, E extends Entity> {

    I getAttackChance(E attacker, E defender);

    I getDefendChance(E attacker, E defender);

    List<StatChange> getImpact(E attacker, E defender, I attackChance, I defendChance);

}
