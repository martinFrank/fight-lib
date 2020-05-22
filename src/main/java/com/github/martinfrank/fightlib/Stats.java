package com.github.martinfrank.fightlib;

import java.util.List;

public interface Stats {

    Stat getStat(Object identifier);

    void changeStats(List<StatChange> impact);

}
