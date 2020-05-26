package com.github.martinfrank.fightlib;

import org.junit.Test;

import static org.junit.Assert.*;

public class AttackProcedureTest {

    private final AttackProcedure attackProcedure = new AttackProcedure(new TestFightRules());
    private TestEntity attacker = new TestEntity("attacker");

    @Test
    public void test_successfulAttack_withFailingDefense_procedureExecution() {
        //given
        TestEntity defender = new TestEntity("defender");
        attacker.setSupposedToSucceedInAttack(true);
        defender.setSupposedToSucceedInDefense(false);
        double defenderLifeBefore = defender.getStats().getStat(TestStatIdentifier.HEALTH).getCurrent();

        //when
        Result result = attackProcedure.performAttack(attacker, defender);
        result.entries().forEach(System.out::println);
        double defenderLifeAfter = defender.getStats().getStat(TestStatIdentifier.HEALTH).getCurrent();

        //then
        assertEquals(1, defenderLifeBefore, 0.01);
        assertEquals(0, defenderLifeAfter, 0.01);
        assertNotNull(result);
        assertFalse(result.entries().isEmpty());

    }

    @Test
    public void test_failingAttack_ProcedureExecution() {
        //given
        TestEntity defender = new TestEntity("defender");
        attacker.setSupposedToSucceedInAttack(false);
        defender.setSupposedToSucceedInDefense(false);
        double defenderLifeBefore = defender.getStats().getStat(TestStatIdentifier.HEALTH).getCurrent();

        //when
        Result result = attackProcedure.performAttack(attacker, defender);
        result.entries().forEach(System.out::println);
        double defenderLifeAfter = defender.getStats().getStat(TestStatIdentifier.HEALTH).getCurrent();

        //then
        assertEquals(1, defenderLifeBefore, 0.01);
        assertEquals(1, defenderLifeAfter, 0.01);
        assertNotNull(result);
        assertFalse(result.entries().isEmpty());

    }

    @Test
    public void test_successfulAttack_withSuccessfulDefense_procedureExecution() {
        //given
        TestEntity defender = new TestEntity("defender");
        attacker.setSupposedToSucceedInAttack(true);
        defender.setSupposedToSucceedInDefense(true);
        double defenderLifeBefore = defender.getStats().getStat(TestStatIdentifier.HEALTH).getCurrent();

        //when
        Result result = attackProcedure.performAttack(attacker, defender);
        result.entries().forEach(System.out::println);
        double defenderLifeAfter = defender.getStats().getStat(TestStatIdentifier.HEALTH).getCurrent();

        //then
        assertEquals(1, defenderLifeBefore, 0.01);
        assertEquals(1, defenderLifeAfter, 0.01);
        assertNotNull(result);
        assertFalse(result.entries().isEmpty());

    }

}
