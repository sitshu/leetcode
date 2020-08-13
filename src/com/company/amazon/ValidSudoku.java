package com.company.amazon;

import java.util.HashSet;

public class ValidSudoku {


   public static void  main(String[] args) {
       char[][] board = {   {'.','.','4','.','.','.','6','3','.'},
               {'.','.','.','.','.','.','.','.','.'},
               {'5','.','.','.','.','.','.','9','.'},
               {'.','.','.','5','6','.','.','.','.'},
               {'4','.','3','.','.','.','.','.','1'},
               {'.','.','.','7','.','.','.','.','.'},
               {'.','.','.','5','.','.','.','.','.'},
               {'.','.','.','.','.','.','.','.','.'},
               {'.','.','.','.','.','.','.','.','.'}};
       boolean val = isValidSudoku(board);
        return;
   }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        for(int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }


        for(int i=0; i< board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(Character.isDigit(board[i][j])){
                    if(!rows[i].add(board[i][j])
                            || !col[j].add(board[i][j])
                            || !box[(i/3) * 3 + j/3].add(board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
