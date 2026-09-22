import java.util.Scanner;

public class KnightTour {
    private static final int boardSize = 8; // Size of the chess board

    // Function to print the chess board
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    // Check if (x, y) is a valid move
    private static boolean isSafe(int xAxis, int yAxis, int[][] board) {
        return (xAxis >= 0 && xAxis < boardSize && yAxis >= 0 && yAxis < boardSize && board[xAxis][yAxis] == -1);
    }

    // Recursive calls
    private static boolean move1(int[][] board, int moveCount, int xAxis, int yAxis) {
        return tryMove(board, moveCount, xAxis + 2, yAxis + 1);
    }
    private static boolean move2(int[][] board, int moveCount, int xAxis, int yAxis) {
        return tryMove(board, moveCount, xAxis + 1, yAxis + 2);
    }
    private static boolean move3(int[][] board, int moveCount, int xAxis, int yAxis) {
        return tryMove(board, moveCount, xAxis - 1, yAxis + 2);
    }
    private static boolean move4(int[][] board, int moveCount, int xAxis, int yAxis) {
        return tryMove(board, moveCount, xAxis - 2, yAxis + 1);
    }
    private static boolean move5(int[][] board, int moveCount, int xAxis, int yAxis) {
        return tryMove(board, moveCount, xAxis - 2, yAxis - 1);
    }
    private static boolean move6(int[][] board, int moveCount, int xAxis, int yAxis) {
        return tryMove(board, moveCount, xAxis - 1, yAxis - 2);
    }
    private static boolean move7(int[][] board, int moveCount, int xAxis, int yAxis) {
        return tryMove(board, moveCount, xAxis + 1, yAxis - 2);
    }
    private static boolean move8(int[][] board, int moveCount, int xAxis, int yAxis) {
        return tryMove(board, moveCount, xAxis + 2, yAxis - 1);
    }

    // Try to move the knight to the next position
    private static boolean tryMove(int[][] board, int moveCount, int nextX, int nextY) {
        if (isSafe(nextX, nextY, board)) {
            board[nextX][nextY] = moveCount;
            if (solveKnightsTour(board, moveCount + 1, nextX, nextY)) {
                return true;
            }
            board[nextX][nextY] = -1; // Backtrack
        }
        return false;
    }

    // Recursive function to solve the Knight's Tour problem
    private static boolean solveKnightsTour(int[][] board, int moveCount, int xAxis, int yAxis) {
        if (moveCount == boardSize * boardSize) {
            return true; // Solution found
        }

        // Separate recursive calls for each move
        return move1(board, moveCount, xAxis, yAxis) ||
               move2(board, moveCount, xAxis, yAxis) ||
               move3(board, moveCount, xAxis, yAxis) ||
               move4(board, moveCount, xAxis, yAxis) ||
               move5(board, moveCount, xAxis, yAxis) ||
               move6(board, moveCount, xAxis, yAxis) ||
               move7(board, moveCount, xAxis, yAxis) ||
               move8(board, moveCount, xAxis, yAxis);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[][] board = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = -1;
            }
        }

        int startX = 0;
        int startY = 0;
        board[startX][startY] = 0;

        if (!solveKnightsTour(board, 1, startX, startY)) {
            System.out.println("No solution exists");
        } else {
            System.out.println("Knight's Tour completed:");
            printBoard(board);
        }
        scnr.close();
    }
}
