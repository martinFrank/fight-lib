package com.github.martinfrank.fightlib;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AttackProcedureTest {

    @Test
    public void testAttackProcedureExecution() {
        //given
        Entity attacker = new TestEntity("attacker");
        Entity defender = new TestEntity("defender");
        RuleBook rules = new TestRuleBook();
        double defenderLifeBefore = defender.getStats().getStat(TestStatIdentifier.HEALTH).getCurrent();

        //when
        AttackProcedure procedure = new AttackProcedure(rules);
        Result result = procedure.performAttack(attacker, defender);
        result.entries().forEach(System.out::println);
        double defenderLifeAfter = defender.getStats().getStat(TestStatIdentifier.HEALTH).getCurrent();

        //then
        Assert.assertEquals(1, defenderLifeBefore, 0.01);
        Assert.assertEquals(0, defenderLifeAfter, 0.01);
        assertNotNull(result);

    }

}
