package com.github.martinfrank.fightlib;

public class Attack {

    private final Entity attacker;
    private final Entity defender;

    public Attack(Entity attacker, Entity defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Result execute() {
        Result result = new Result();
        result.append("attack begins");
        result.append(attacker + " attacks " + defender);
        result.append("--------");
        result.append("");

        Chance attackChance = attacker.getAttackChance(defender);
        result.append("chance of successful attack is: " + attackChance);
        attackChance.roll();
        boolean attackRollSuccess = attackChance.wasSuccessful();
        result.append("attacker rolled: " + attackChance.getRollResult() + ", attack was successful=" + attackRollSuccess);
        result.append("");

        if (attackRollSuccess) {
            Chance defendChance = defender.getDefendChance(attacker);
            result.append("chance of successful block the attack is: " + defendChance);
            defendChance.roll();
            boolean defendRollSuccess = defendChance.wasSuccessful();
            result.append("defender rolled: " + defendChance.getRollResult() + ", defense was successful=" + defendRollSuccess);
            result.append("");
            if (defendRollSuccess) {
                result.append("defender successfully blocked the attack");
            } else {
                result.append("defender could not block the attack - time to take some damage....");
                applyDamage(attacker, defender);
            }
        } else {
            result.append("attack was not successful");
        }

        result.append("");
        result.append("attack is done");
        result.append("--------");
        result.append("");

        return result;
    }

    private void applyDamage(Entity attacker, Entity defender) {
    }
}
