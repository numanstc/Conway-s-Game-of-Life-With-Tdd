package com.numanstc.game.rules;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RuleStrategyTest {

    @Test
    @DisplayName("Eğer 2'den az komşusu varsa ölür")
    void ItShouldDieWhenUnderpopulation() {
        boolean status = RuleStrategy.getStatus(true, 1);
        assertFalse(status);
    }

    @Test
    @DisplayName("Eğer 3'den fazla komşusu varsa ölür")
    void itShouldDieWhenOverpopulation() {
        boolean status = RuleStrategy.getStatus(true, 4);
        assertFalse(status);
    }

    @Test
    @DisplayName("Eğer 3 komşusu varsa ve ölüyse yaşama döner")
    void itShouldGetLiveWhenReproduction () {
        boolean status = RuleStrategy.getStatus(false, 3);
        assertTrue(status);
    }

}
