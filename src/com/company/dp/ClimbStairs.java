package com.company.dp;

public class ClimbStairs {
    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = climbStairs(4);
        System.out.println(result);
    }
    public static int climbStairs(int n) {

        int[] arr  = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < n+1 ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];

    }
}
