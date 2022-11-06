package com.numanstc.game.rules;

public interface Rule {

    boolean condition(boolean status, int neighbors );
    boolean response();
}
