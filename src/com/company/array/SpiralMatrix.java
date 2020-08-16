package com.company.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return new ArrayList();
        boolean[][] visited =new boolean[ matrix.length][matrix[0].length];
        int nn = matrix.length*matrix[0].length;
        int xx = 0; int yy = -1;
        int m = matrix.length; int n = matrix[0].length;
        while(res.size()<nn){
            for(int i=0; i<4; i++){
                xx = xx + dirs[i][0];
                yy = yy + dirs[i][1];
                while(xx >=0 && xx<m && yy>= 0 & yy < n && !visited[xx][yy] ){
                    visited[xx][yy] = true;
                    res.add(matrix[xx][yy]);
                    xx+=dirs[i][0];
                    yy+=dirs[i][1];
                }

                xx -= dirs[i][0];
                yy -= dirs[i][1];
            }

        }

        return res;
    }
}
