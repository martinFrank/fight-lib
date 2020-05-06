package com.github.martinfrank.fightlib;

public interface Entity {

    Attack getAttack();

    Defense getDefense();

    Armor getArmor();

    void applyDamage(Damage taken);
}
