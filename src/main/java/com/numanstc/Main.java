package com.numanstc;

import com.numanstc.game.Board;
import com.numanstc.game.BoardFactory;
import com.numanstc.game.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Board board = BoardFactory.createGlider(20, 20);
        Game game = new Game(board);
        consoleWrite(game.getBoard());
        boolean isBoardChanged;
        do {
            game.iterate();
            clear();
            consoleWrite(game.getBoard());
            isBoardChanged = board.equals(game.getBoard());
            board = game.getBoard();
            Thread.sleep(500);
        } while (!isBoardChanged);

    }

    private static void consoleWrite(Board board) {
        for (int row = 0; row < board.getMaxRowSize(); row++) {
            for (int col = 0; col < board.getMaxColSize(); col++) {
                String mark = board.getStatus(row, col) ? "*" : ".";
                System.out.printf("%s ", mark);
            }
            System.out.println();
        }
    }

    private static void clear() {
        System.out.println("\033[H\033[2J");
    }
}
