package com.company;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i< nums.length; i++) {

            if(!map.containsKey(nums[i])) {
                System.out.println(target-nums[i] + " " + nums[i]);
                map.put(target-nums[i], i);
            } else {
                result[0] = map.get(nums[i]);
                result[1] = i;
            }
        }
        return result;

    }

    public static void main(String[] args) {
	// write your code here

        int[] array = new int[]{3,2,4};

        int[]res = twoSum(array, 6);
        for(int i = 0 ;  i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
