//package com.company.graph;
//
//
//import javafx.util.Pair;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class RottingOranges {
//
//    public static void main(String[] args) {
//        int[][] graph = {{2,1,1},{1,1,0},{0,1,1}};
//        int time = orangesRotting(graph);
//    }
//    public static int orangesRotting(int[][] grid) {
//        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//        int m = grid.length;
//        int n = grid[0].length;
//        int count = 0;
//        Queue<Pair> queue = new LinkedList<>();
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++) {
//                if(grid[i][j] == 2){
//                    Pair pair = new Pair(i,j);
//                    queue.add(pair);
//                } else if(grid[i][j] == 2) {
//                    count++;
//                }
//            }
//        }
//        queue.add(new Pair(-1,-1));
//        int timestamp =-1;
//        while(!queue.isEmpty()) {
//            Pair<Integer,Integer> pair = queue.poll();
//            int row = pair.getKey();
//            int col = pair.getValue();
//            if(row == -1) {
//                timestamp++;
//                if(!queue.isEmpty()){
//                    queue.add(new Pair(-1,-1));
//                }
//            } else {
//                for(int i=0; i<4; i++) {
//                    int newx = directions[i][0]+ row;
//                    int newy = directions[i][1] + col;
//                    if(newx>=0
//                            && newy>=0
//                            && newx <m
//                            && newy< n
//                            && grid[newx][newy] == 1){
//                        queue.offer(new Pair(newx, newy));
//                        grid[newx][newy] = 2;
//                        count--;
//                    }
//
//                }
//            }
//        }
//
//        return count==0? timestamp: -1;
//    }
//}
