public class Solver {

    private final int BOARDMAX = 9;
    private final int SQUAREMAX = 3;

    private boolean rowValid(int[][] board, int input, int row) {
        for (int i = 0; i < BOARDMAX; i++) {
            if (board[row][i] == input) {
                return false;
            }
        }
        return true;
    }

    private boolean colValid(int[][] board, int input, int col) {
        for (int i = 0; i < BOARDMAX; i++) {
            if (board[i][col] == input) {
                return false;
            }
        }
        return true;
    }

    private boolean squareValid(int[][] board, int input, int row, int col) {
        int squareRow = row / SQUAREMAX * SQUAREMAX;
        int squareCol = col / SQUAREMAX * SQUAREMAX;
        for (int i = 0; i < SQUAREMAX; i++) {
            for (int j = 0; j < SQUAREMAX; j++) {
                if (board[squareRow + i][squareCol + j] == input) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(int[][] board) {
        for (int row = 0; row < BOARDMAX; row++) {
            for (int col = 0; col < BOARDMAX; col++) {
                if (board[row][col] == 0) {
                    for (int input = 1; input < 10; input++) {
                        if (rowValid(board, input, row) &&
                                colValid(board, input, col) &&
                                squareValid(board, input, row, col)) {
                            board[row][col] = input;
                            if (solve(board)) {
                                return true; // solving recursively
                            } else {
                                board[row][col] = 0; // backtracking
                            }
                        }
                    }
                    return false; // no solution
                }
            }
        }
        return true; // no blank
    }

    public void viewBoard(int[][] board) {
        for (int row = 0; row < BOARDMAX; row ++) {
            for (int col = 0; col < BOARDMAX; col ++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
}
