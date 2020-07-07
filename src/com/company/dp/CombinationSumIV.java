package com.company.dp;

public class CombinationSumIV {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,5};
        int result = combinationSum4(array, 4);
        System.out.println(result);
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i<target+1; i++) {

            for(int j=0; j< nums.length; j++) {

                if(i >= nums[j]) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
