package com.github.martinfrank.fightlib;

public interface Entity {

    Chance getAttackChance(Entity defender);

    Chance getDefendChance(Entity attacker);
}
