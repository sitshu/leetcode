package com.company.array;

import java.util.*;

public class threeSum {

    public static void main(String[] args) {
        // write your code here

        int[] array = new int[]{1,-1,-1,0};

       List list= threeSum(array);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length <3 || nums[0]>0)
            return result;
        for(int i=0;i<nums.length; i++) {

            if(i>0 && nums[i] == nums[i-1])
                continue;
            int left = i+1, right = nums.length-1, sum = -nums[i];
            while(left<right) {
                System.out.println("here"+ left + " " + right);
                if(sum == nums[left] + nums[right] ){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while(left<nums.length && left<right && nums[left+1]==nums[left])
                        left++;
                    while(right>left && right>0 && nums[right-1] == nums[right])
                        right--;
                    left++;
                    right--;
                } else if(sum > nums[left] + nums[right]) {
                    while(left<nums.length && left<right && nums[left+1]==nums[left])
                        left++;
                    left++;
                } else {
                    while(right>left && right>0 && nums[right-1] == nums[right])
                        right--;
                    right--;
                }

            }
        }
        return result;
    }
}
