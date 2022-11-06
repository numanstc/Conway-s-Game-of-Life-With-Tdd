package com.numanstc.game;

public class BoardFactory {
    private static final int DEFAULT_COL_LENGTH = 5;
    private static final int DEFAULT_ROW_LENGTH = 5;

    private BoardFactory() {
    }

    public static Board createBlock() {
        Board board = new Board(DEFAULT_ROW_LENGTH, DEFAULT_COL_LENGTH);
        board.setStatus(true, 1, 1);
        board.setStatus(true, 1, 2);
        board.setStatus(true, 2, 1);
        board.setStatus(true, 2, 2);
        return board;
    }


    public static Board createBeacon() {
        Board board = new Board(DEFAULT_ROW_LENGTH, DEFAULT_COL_LENGTH);
        board.setStatus(true, 1, 1);
        board.setStatus(true, 1, 2);
        board.setStatus(true, 2, 1);
        board.setStatus(true, 2, 2);

        board.setStatus(true, 3, 3);
        board.setStatus(true, 3, 4);
        board.setStatus(true, 4, 3);
        board.setStatus(true, 4, 4);

        return board;
    }

    public static Board createGlider(int rowLength, int colLength) {
        if (rowLength < 4 || colLength < 4)
            throw new RuntimeException("Lengths not enough!");

        Board board = new Board(rowLength, colLength);
        board.setStatus(true, 3, 3);
        board.setStatus(true, 3, 2);
        board.setStatus(true, 3, 1);
        board.setStatus(true, 2, 3);
        board.setStatus(true, 1, 2);

        return board;
    }
}
