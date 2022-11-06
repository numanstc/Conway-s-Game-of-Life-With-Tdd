package com.numanstc.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game sut;

    public static Stream<Arguments> createExamplePattern() {
        Board beaconExpected = BoardFactory.createBeacon();
        beaconExpected.setStatus(false, 2, 2);
        beaconExpected.setStatus(false, 3, 3);

        return Stream.of(
                Arguments.of(BoardFactory.createBlock(), BoardFactory.createBlock(), "Block"),
                Arguments.of(beaconExpected, BoardFactory.createBeacon(), "Beacon")
        );
    }

    @ParameterizedTest(name = "One iteration test for {2}")
    @MethodSource("createExamplePattern")
    void itShouldCheckOneIterateForPatterns(Board expected, Board initial, String name) {
        sut = new Game(initial);
        sut.iterate();
        Board result = sut.getBoard();

        assertEquals(expected, result);
    }
}
