package com.company.graph;

import java.util.List;

public class NumberOfIslands {
    static int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0, -1}};
    public static int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i< m; i++) {
            for(int j=0; j< n; j++) {
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(i, j, grid, visited);

                }
            }
        }

        return count;
    }

    public static void dfs(int i, int j, char[][] matrix, boolean[][] visited) {

        int row = matrix.length;
        int column = matrix[0].length;
        visited[i][j] = true;

        for(int x = 0; x<4; x++) {
            int m = dirs[x][0] + i;
            int n= dirs[x][1] + j;
            if(m<0 || n< 0 || m>row-1 || n > column-1)
                continue;
            if(matrix[m][n] == '1' && !visited[m][n])
                dfs(m,n, matrix, visited);
        }


    }
    public static void main(String[] args) {
        char[][] matrix = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int integer = numIslands(matrix) ;
        return;
    }
}
