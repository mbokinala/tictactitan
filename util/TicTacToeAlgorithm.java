package util;

public abstract class TicTacToeAlgorithm {
    private static String name;

    // accepts a board and returns the next move as a an array in the format [row, col];
    public abstract int[] nextMove(int[][] board);

    public String getName() {
        return name;
    }
}