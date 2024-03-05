package coding_practice.recursionAndBacktracking;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> list = solveQueen(n);
        for(List<String> res : list){
            for(Object i : res){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveQueen(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solveUntil(0, board, result);

        return result;
    }

    private static void solveUntil(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solveUntil(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {

         // Check if there's a queen in the same column
       for(int i=0;i<row;i++){
        if(board[i][col] == 'Q') return false;
       }

        // Check if there's a queen in the left diagonal
       for(int i=row,j=col;i>=0 && j>=0;i--,j--){
        if(board[i][j] == 'Q') return false;
       }

       // Check if there's a queen in the right diagonal
       for(int i=row,j=col;i>=0 && j<board.length;i--,j++){
        if(board[i][j] == 'Q') return false;
       }

       return true;
    }

    private static List<String> constructBoard(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] res : board) {
            solution.add(new String(res));
        }
        return solution;
    }
}
