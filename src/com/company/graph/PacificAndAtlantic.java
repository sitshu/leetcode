package com.company.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAndAtlantic {


    static int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<m ; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 || j==0)
                    dfs(i, j, matrix, pacific);
                if(i==m-1 || j== n-1)
                    dfs(i, j, matrix, atlantic);
            }
        }

        for(int i=0; i<m ; i++) {
            for(int j=0; j<n; j++) {
                if(pacific[i][j] && atlantic[i][j] ){
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }

            }
        }
        return list;
    }


    public static void dfs(int i, int j, int[][] matrix, boolean[][] visited) {

        int row = matrix.length;
        int column = matrix[0].length;
        visited[i][j] = true;

        for(int x = 0; x<4; x++) {
            int m = dirs[x][0] + i;
            int n= dirs[x][1] + j;
            if(m<0 || n< 0 || m>row-1 || n > column-1)
                continue;
            if(!visited[m][n] && matrix[m][n] >= matrix[i][j])
                dfs(m, n, matrix, visited);
        }

    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        List<List<Integer>> integer = pacificAtlantic(matrix) ;
        return;
    }

}
