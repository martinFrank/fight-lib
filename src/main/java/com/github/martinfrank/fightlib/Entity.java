package com.github.martinfrank.fightlib;

public interface Entity {

    Chance getAttackChance(Entity defender);

    Chance getDefendChance(Entity attacker);

    Damage getDamage(Entity defender);

    void applyDamage(Damage damage);
}
