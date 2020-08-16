package com.company.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    class Pair {
        int i;
        int y;
        Pair(int i, int y){
            this.i = i;
            this.y = y;
        }

        public int getKey(){
            return this.i;
        }
        public int getValue() {
            return this.y;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        if(m==0)
            return false;
        if(start[0] == destination[0]  && start[1] == destination[1])
            return true;
        Queue<Pair> queue = new LinkedList<>();
        Pair source = new Pair(start[0], start[1]);
        queue.offer(source);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();

            for(int i=0; i<4; i++){
                int xx = x +dir[i][0];
                int yy = y + dir[i][1];

                while(xx >=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]!=1){
                    xx += dir[i][0];
                    yy+=dir[i][1];
                }

                xx -= dir[i][0];
                yy -= dir[i][1];

                if(visited[xx][yy])
                    continue;
                if(xx == destination[0]  && yy == destination[1])
                    return true;
                visited[xx][yy] = true;
                queue.offer(new Pair(xx, yy));
            }
        }

        return false;

    }
}
