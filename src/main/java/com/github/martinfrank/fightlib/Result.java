package com.github.martinfrank.fightlib;

import java.util.List;

public interface Result {

    void append(String line);

    List<String> entries();
}
