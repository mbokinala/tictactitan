package util;

public class Game {
    /**
     * each space on the board is represented by an integer
     * 0 = empty
     * 1 = X
     * 2 = O
     */
    private int[][] board = new int[10][10];

    private TicTacToeAlgorithm playerA; // X
    private TicTacToeAlgorithm playerB; // O

    // runs a game between playerA and playerB and returns the winner
    public TicTacToeAlgorithm playGame() {
        int currentPlayerNumber = 1;
        
        while (checkWin() == 0) {
            TicTacToeAlgorithm currentPlayer = (currentPlayerNumber == 1 ) ? playerA : playerB;

            int[] move = currentPlayer.nextMove(board);
            board[move[0]][move[1]] = currentPlayerNumber;

            // switch the current player
            currentPlayerNumber = (currentPlayerNumber == 1) ? 2 : 1;
        }

        TicTacToeAlgorithm winner = (checkWin() == 1) ? playerA : playerB;

        return winner;
    }

    // checks board for a win and returns the winner number. if no winner, returns 0
    private int checkWin() {
        // TODO: implement check
        if (Math.random() < 0.1) {
            return (Math.random() < 0.5) ? 1 : 2;
        }
        return 0;
    }
}
