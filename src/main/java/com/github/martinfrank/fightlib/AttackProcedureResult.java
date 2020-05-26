package com.github.martinfrank.fightlib;

import java.util.ArrayList;
import java.util.List;

public class AttackProcedureResult implements Result {

    private final List<String> log = new ArrayList<>();

    @Override
    public void append(String line) {
        log.add(line);
    }

    @Override
    public List<String> entries() {
        return log;
    }

    void logAttackSucceeded(Chance defendChance) {
        append("attack was successful (attacker hit)");
        append("chance of successful block the attack is: " + defendChance);
        append("defender rolled: " + defendChance.getRollResult() + ", defense was successful=" + defendChance.wasSuccessful());
        append("");
    }

    void logOutro(Entity attacker, Entity defender) {
        append("");
        append("attack is done, " + attacker + ", " + defender);
        append("--------");
        append("");
    }

    void logAttackChance(Chance attackChance) {
        append("chance of successful attack is: " + attackChance);
        append("attacker rolled: " + attackChance.getRollResult() + ", attack was successful=" + attackChance.wasSuccessful());
        append("");
    }

    void logIntro(Entity attacker, Entity defender) {
        append("attack begins");
        append(attacker + " attacks " + defender);
        append("--------");
        append("");
    }

    void logDefendSucceeded() {
        append("defender successfully avoided the attack");
    }

    void logDefendFailed() {
        append("defender could not avoid the attack - time to take some damage....");
    }

    void logAttackFailed() {
        append("attack was not successful (attacker missed)");
    }

    void logImpact(List<StatChange> impact) {
        append("giving impact: " + impact);
    }
}
