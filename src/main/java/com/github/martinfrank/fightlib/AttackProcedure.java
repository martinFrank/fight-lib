package com.github.martinfrank.fightlib;

public class AttackProcedure {

    private final Entity attacker;
    private final Entity defender;
    private final Chance attackChance;
    private final Chance defendChance;
    private final Result result;

    public AttackProcedure(Entity attacker, Entity defender) {
        this.attacker = attacker;
        this.defender = defender;

        attackChance = attacker.getAttackChance(defender);
        defendChance = defender.getDefendChance(attacker);

        result = new Result();
    }

    public Result execute() {
        result.append("attack begins");
        result.append(attacker + " attacks " + defender);
        result.append("--------");
        result.append("");

        result.append("chance of successful attack is: " + attackChance);
        attackChance.roll();
        boolean attackRollSuccess = attackChance.wasSuccessful();
        result.append("attacker rolled: " + attackChance.getRollResult() + ", attack was successful=" + attackRollSuccess);
        result.append("");

        if (attackRollSuccess) {
            result.append("chance of successful block the attack is: " + defendChance);
            defendChance.roll();
            boolean defendRollSuccess = defendChance.wasSuccessful();
            result.append("defender rolled: " + defendChance.getRollResult() + ", defense was successful=" + defendRollSuccess);
            result.append("");
            if (defendRollSuccess) {
                result.append("defender successfully blocked the attack");
            } else {
                result.append("defender could not block the attack - time to take some damage....");
                applyDamage(attacker, defender, attackChance, defendChance);
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

    private void applyDamage(Entity attacker, Entity defender, Chance attackChance, Chance defendChance) {
        Damage damage = attacker.getDamage(defender);
        damage.applyChanceModifier(attackChance, defendChance);
        defender.applyDamage(damage);
    }
}
