package com.numanstc.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private final Board board = new Board(5, 5);

    @Test
    void itShouldGetStatus() {
        boolean status = board.getStatus(2, 2);
        assertFalse(status);
    }

    @Test
    void itShouldSetStatus() {
        board.setStatus(true, 2, 2);
        boolean status = board.getStatus(2, 2);
        assertTrue(status);
    }

    @Test
    void itShouldGetNeighborCount() {
        board.setStatus(true, 1, 1);
        board.setStatus(true, 1, 2);
        board.setStatus(true, 2, 1);
        board.setStatus(true, 2, 2);

        int neighborsCount = board.getNeighbors(2, 2);

        assertEquals(3, neighborsCount);
    }

    @Test
    void itShouldGetNeighborsForTopLeftCorner() {
        board.setStatus(true, 1, 1);
        board.setStatus(true, 1, 0);
        board.setStatus(true, 0, 1);

        int neighborsCount = board.getNeighbors(0, 0);

        assertEquals(3, neighborsCount);
    }

    @Test
    void itShouldGetNeighborsForBottomRightCorner() {
        board.setStatus(true, 4, 4);
        board.setStatus(true, 3, 3);

        int neighborsCount = board.getNeighbors(4, 4);

        assertEquals(1, neighborsCount);
    }

    public static Stream<Arguments> createEqualCases() {

        Board b1 = new Board(3, 3);
        Board b2 = new Board(2, 3);
        Board b3 = new Board(3, 2);

        Board b4 = new Board(10, 10);
        b4.setStatus(true, 4, 4);
        Board b5 = new Board(10, 10);
        b5.setStatus(true, 4, 4);

        Board b6 = new Board(10, 10);
        b6.setStatus(true, 4, 4);
        Board b7 = new Board(10, 10);
        b7.setStatus(true, 3, 4);

        return Stream.of(
                Arguments.of(b1, b2, false),
                Arguments.of(b1, b3, false),
                Arguments.of(b2, b3, false),
                Arguments.of(b4, b5, true),
                Arguments.of(b6, b7, false)
        );
    }

    @ParameterizedTest
    @MethodSource("createEqualCases")
    void itShouldEqual(Board b1, Board b2, boolean expected) {
        assertEquals(expected, b1.equals(b2));
    }
}
