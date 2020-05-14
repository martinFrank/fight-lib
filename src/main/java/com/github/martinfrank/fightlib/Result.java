package com.github.martinfrank.fightlib;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<String> log = new ArrayList<>();

    void append(String line) {
        log.add(line);
    }

    public List<String> entries() {
        return log;
    }
}
