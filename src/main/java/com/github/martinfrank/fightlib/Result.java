package com.github.martinfrank.fightlib;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final Entity attacker;
    private final Entity defender;
    private final List<String> log = new ArrayList<>();

    public Result(Entity attacker, Entity defender) {
        this.attacker = attacker;
        this.defender = defender;


    }

    void append(String line) {
        log.add(line);
    }

    public List<String> entries() {
        return log;
    }
}
