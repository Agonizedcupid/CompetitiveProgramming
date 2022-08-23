package com.aariyan.cp;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        int[] array = new int[] {1,2,3};

        System.out.print(checkIfPossibleToSolve(board));
    }

    private static boolean isValid(char board[][], int row, int col, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k || board[row][i] == k) { // row and column check
                return false;
            }
        }
        // grid check
        int gridRow = (row / 3) * 3;
        int gridCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[gridRow + i][gridCol + j] == k) {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean checkIfPossibleToSolve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (checkIfPossibleToSolve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        System.out.print("[");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board.length; j++) {
                System.out.printf("\"%c\",", board[i][j]);
            }
            System.out.print("]");
        }
        System.out.print("]\n");
        return true;
    }
}
