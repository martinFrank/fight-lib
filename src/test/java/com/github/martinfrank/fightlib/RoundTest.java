package com.github.martinfrank.fightlib;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoundTest {

    @Test
    public void testRound(){
        //given
        Entity attacker = createAttack();
        Entity defender = createDefender();
        Round round = new Round();

        //when
        Result result = round.execute(attacker, defender);
        result.entries().forEach(System.out::println);

        //then
        assertNotNull(result);
    }

    private Entity createDefender() {
        return new Entity() {

            @Override
            public Attack getAttack() {
                return null;
            }

            @Override
            public Defense getDefense() {
                return null;
            }

            @Override
            public Armor getArmor() {
                return null;
            }

            @Override
            public void applyDamage(Damage taken) {

            }
        };
    }

    private Entity createAttack() {
        return createDefender();
    }
}
