package com.numanstc.game.rules;

public enum RuleStrategy {
    UNDERPOPULATION(new UnderpopulationRule()),
    OVERPOPULATION (new OverpopulationRule()),
    REPRODUCTION(new ReproductionRule());

    private final Rule rule;

    RuleStrategy(Rule rule) {
        this.rule = rule;
    }

    public static boolean getStatus(boolean status, int neighbors) {
        for (RuleStrategy strategy : values()) {
            if (strategy.rule.condition(status, neighbors))
                return strategy.rule.response();
        }
        return status;
    }

}
