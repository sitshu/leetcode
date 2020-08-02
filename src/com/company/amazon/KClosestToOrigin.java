package com.company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestToOrigin {
    public static void main(String[] args) {
        int[][] array = {{1,3}, {-2,2}};
        int[][] res = kClosest(array, 1);
        return;

    }
    public static int[][] kClosest(int[][] points, int K) {
        int k = K;
        int[] distance = new int[points.length];
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i< points.length ; i++) {
            distance[i] = findDist(points[i]);
        }
        Arrays.sort(distance);

        int maxDist = distance[k-1];

        for(int i=0; i<points.length ; i++) {
            if(findDist(points[i])<=maxDist){
                result.add(points[i]);
            }
            if(result.size() ==k) {
                return result.toArray(new int[k][2]);
            }
        }
        return result.toArray(new int[k][2]);
    }

    public static int findDist(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
