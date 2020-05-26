package com.github.martinfrank.fightlib;

import java.util.List;

public class AttackProcedure {

    private final FightRules rules;

    public AttackProcedure(FightRules rules) {
        this.rules = rules;
    }

    public Result performAttack(Entity attacker, Entity defender) {
        AttackProcedureResult result = new AttackProcedureResult();
        result.logIntro(attacker, defender);

        Chance attackChance = rules.getAttackChance(attacker, defender);
        Chance defendChance = rules.getDefendChance(attacker, defender);

        result.logAttackChance(attackChance);

        if (attackChance.wasSuccessful()) {
            result.logAttackSucceeded(defendChance);
            if (defendChance.wasSuccessful()) {
                result.logDefendSucceeded();
            } else {
                result.logDefendFailed();
                applyDamage(attacker, defender, attackChance, defendChance, result);
            }
        } else {
            result.logAttackFailed();
        }
        result.logOutro(attacker, defender);
        return result;
    }

    private void applyDamage(Entity attacker, Entity defender, Chance attackChance, Chance defendChance, AttackProcedureResult result) {
        List<StatChange> impact = rules.getImpact(attacker, defender, attackChance, defendChance);
        result.logImpact(impact);
        defender.getStats().changeStats(impact);
    }

}
