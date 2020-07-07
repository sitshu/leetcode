package com.company;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(array);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int max = nums[0];

        for(int i=1; i< nums.length; i++) {
           if(nums[i] < 0) {
               int t = max_so_far;
               max_so_far = min_so_far;
               min_so_far = t;
           }
          max_so_far = max(nums[i], max_so_far*nums[i]);
           min_so_far = min(nums[i], min_so_far*nums[i]);
           max = max(max, max_so_far);
        }
        return max;
    }
}
