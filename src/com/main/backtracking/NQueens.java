package com.main.backtracking;

/*
 * You are given a chess board of size N x N, where N is at most 8. You have to place N queens in this board such
 * that no two queens can attack. Write a function that takes N as an argument and prints out the position of N queens.
 */

public class NQueens {
    public static void main(String[] args) {
        nQueens(new int[8], 0);
    }

    private static boolean nQueens(int[] board, int index) {
        if (index == board.length) {
            for (int row : board) {
                for (int i = 0; i < board.length; i++) {
                    if (i == row) {
                        System.out.print(" O ");
                    } else {
                        System.out.print(" X ");
                    }
                }
                System.out.println("");
            }
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (board[j] == i || Math.abs(board[j] - i) == (index - j)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            board[index] = i;
            if (nQueens(board, index + 1)) {
                return true;
            }
        }
        return false;
    }
}
