package com.company.array;

public class JumpGameII {


    public static void main(String[] args) {

        int[] a = {2,3,1,1,4};
        int r = jump(a);
        return;

    }
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        // max position one could reach
        // starting from index <= i
        int maxPos = nums[0];
        // max number of steps one could do
        // inside this jump
        int maxSteps = nums[0];

        int jumps = 1;
        for (int i = 1; i < n; ++i) {
            // if to reach this point
            // one needs one more jump
            if (maxSteps < i) {
                ++jumps;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jumps;
    }

}
