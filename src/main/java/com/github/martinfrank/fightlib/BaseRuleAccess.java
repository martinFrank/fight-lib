package com.github.martinfrank.fightlib;

public class BaseRuleAccess implements RuleAccess {

    private final RuleBook rules;

    public BaseRuleAccess(RuleBook rules) {
        this.rules = rules;
    }

    @Override
    public RuleBook getRules() {
        return rules;
    }
}
