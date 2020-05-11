package com.github.martinfrank.fightlib;

public class Round {

    public Result execute(Entity attacker, Entity defender) {
        Result result = new Result(attacker, defender);
        result.append("begin");
        result.append("Attacker : " + attacker);
        result.append("Defender : " + defender);

        result.append("end");
        return result;
    }
}
