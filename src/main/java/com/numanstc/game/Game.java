package com.numanstc.game;


import com.numanstc.game.rules.RuleStrategy;

public final class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void iterate() {
        Board newBoard = new Board(board.getMaxRowSize(), board.getMaxColSize());
        for (int row = 0; row < board.getMaxRowSize(); row++) {
            for (int col = 0; col < board.getMaxColSize(); col++) {
                boolean status = board.getStatus(row, col);
                int neighbors = board.getNeighbors(row, col);
                boolean newStatus = RuleStrategy.getStatus(status, neighbors);
                newBoard.setStatus(newStatus, row, col);
            }
        }
        this.board = newBoard;
    }

    public Board getBoard() {
        return board;
    }

}
