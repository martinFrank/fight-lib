package com.github.martinfrank.fightlib;

import java.util.List;

public class AttackProcedure extends BaseRuleAccess {

    public AttackProcedure(RuleBook rules) {
        super(rules);
    }

    private static void logDefendChance(Result log, Chance defendChance) {
        log.append("chance of successful block the attack is: " + defendChance);
        log.append("defender rolled: " + defendChance.getRollResult() + ", defense was successful=" + defendChance.wasSuccessful());
        log.append("");
    }

    private static void logOutro(Result log) {
        log.append("");
        log.append("attack is done");
        log.append("--------");
        log.append("");
    }

    private static void logAttackChance(Result log, Chance attackChance) {
        log.append("chance of successful attack is: " + attackChance);
        log.append("attacker rolled: " + attackChance.getRollResult() + ", attack was successful=" + attackChance.wasSuccessful());
        log.append("");
    }

    private static void logIntro(Result log, Entity attacker, Entity defender) {
        log.append("attack begins");
        log.append(attacker + " attacks " + defender);
        log.append("--------");
        log.append("");
    }

    public Result performAttack(Entity attacker, Entity defender) {
        Result log = new Result();
        logIntro(log, attacker, defender);

        Chance attackChance = getRules().getAttackChance(attacker, defender);
        Chance defendChance = getRules().getDefendChance(attacker, defender);

        logAttackChance(log, attackChance);

        if (attackChance.wasSuccessful()) {
            log.append("attack was successful (attacker hit)");
            logDefendChance(log, defendChance);
            if (defendChance.wasSuccessful()) {
                log.append("defender successfully blocked the attack");
            } else {
                log.append("defender could not block the attack - time to take some damage....");
                applyDamage(attacker, defender, attackChance, defendChance, log);
            }
        } else {
            log.append("attack was not successful (attacker missed)");
        }

        logOutro(log);

        return log;
    }

    private void applyDamage(Entity attacker, Entity defender, Chance attackChance, Chance defendChance, Result log) {
        List<StatChange> impact = getRules().getImpact(attacker, defender, attackChance, defendChance);
        log.append("giving impact: " + impact);
        defender.getStats().changeStats(impact);
    }

}
