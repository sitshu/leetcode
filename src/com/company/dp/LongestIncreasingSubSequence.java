package com.company.dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] array = new int[]{4,10,4,3,8,9};
        int length = array.length;
        int[][] dp = new int[array.length + 1][array.length];

        for(int i= 0 ; i< length+1; i++) {
            for(int j=0; j<length; j++) {
                dp[i][j] = -1;
            }
        }

        int result = lis(array, -1,0,dp);
        int resultdp = dp(array);
    }





    private static int lis(int[] nums, int prev, int position, int[][] dp) {

        if(position == nums.length)
            return 0;
        if(dp[prev+1][ position]>0){
            return dp[prev+1][position];
        }

        int taken = 0;
        if(prev <0 || nums[prev] < nums[position])
            taken = 1 + lis(nums, position, position+1, dp);
        int nottaken = lis(nums, prev, position+1, dp);

        dp[prev+1][position] = Math.max(taken, nottaken);
        return dp[prev+1][position];


    }

    private static int dp(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];

        dp[0] = 1;
        int returnVal = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxSequence = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxSequence = Math.max(maxSequence, dp[j]);
                }


            }
            dp[i] = maxSequence + 1;
            returnVal = Math.max(returnVal, dp[i]);
        }
        return returnVal;
    }
}
