package com.github.martinfrank.fightlib;

import org.junit.Test;

import static org.junit.Assert.*;

public class AttackProcedureTest {

    @Test
    public void testAttackProcedureExecution() {
        //given
        Entity attacker = new TestEntity("attacker", new WinningChance(), new WinningChance());
        Entity defender = new TestEntity("defender", new FailingChance(), new FailingChance());

        //when
        AttackProcedure attack = new AttackProcedure(attacker, defender);
        Result result = attack.execute();
        result.entries().forEach(System.out::println);

        //then
        assertNotNull(result);

    }

}
