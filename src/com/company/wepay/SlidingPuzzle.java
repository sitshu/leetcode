package com.company.wepay;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for(int i=0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                start+=board[i][j];
            }
        }

        Set<String> visited = new HashSet<>();
        int[][] dirs = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4} };
        Queue<String> queue = new LinkedList<>();
        int res = 0;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                String next = queue.poll();
                if(target.equals(next)){
                    return res;
                }
                int index = next.indexOf("0");
                for(int dir: dirs[index]){
                    String neighbor = swap(next, index, dir);
                    if(visited.add(neighbor)){
                        queue.offer(neighbor);
                    }
                }

            }
            res++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
