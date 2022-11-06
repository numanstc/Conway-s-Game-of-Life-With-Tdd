package com.numanstc.game;

import java.util.Arrays;
import java.util.Objects;

public class Board {
    private final int maxRowSize;
    private final int maxColSize;
    private final boolean[][] matrix;

    public Board(int row, int col) {
        this.maxRowSize = row;
        this.maxColSize = col;

        matrix = new boolean[maxRowSize][maxRowSize];
    }

    public boolean getStatus(int row, int col) {
        return matrix[row][col];
    }

    public void setStatus(boolean newStatus, int row, int col) {
        matrix[row][col] = newStatus;
    }

    public int getNeighbors(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            if (i < 0 || i > maxRowSize - 1)
                continue;

            for (int j = col - 1; j <= col + 1; j++) {
                if (j < 0 || j > maxColSize - 1)
                    continue;

                if (i == row && j == col)
                    continue;

                if (matrix[i][j])
                    count++;
            }
        }
        return count;
    }

    public int getMaxRowSize() {
        return maxRowSize;
    }

    public int getMaxColSize() {
        return maxColSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return maxRowSize == board.maxRowSize
                && maxColSize == board.maxColSize
                && Arrays.deepEquals(matrix, board.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(maxRowSize, maxColSize);
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
    }
}
