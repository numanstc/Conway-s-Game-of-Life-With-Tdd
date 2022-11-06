package com.numanstc.game.rules;

class UnderpopulationRule implements Rule {
    @Override
    public boolean condition(boolean status, int neighbors) {
        return status && neighbors < 2;
    }

    @Override
    public boolean response() {
        return false;
    }
}
