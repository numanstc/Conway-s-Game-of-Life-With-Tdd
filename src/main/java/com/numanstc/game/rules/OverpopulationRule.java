package com.numanstc.game.rules;

class OverpopulationRule implements  Rule{
    @Override
    public boolean condition(boolean status, int neighbors) {
        return status && neighbors > 3;
    }

    @Override
    public boolean response() {
        return false;
    }
}
