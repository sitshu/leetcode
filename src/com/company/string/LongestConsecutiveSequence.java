package com.company.string;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] array = {9,1,4,7,3,-1,0,5,8,-1,6};
        int integer = longestConsecutive(array) ;
        return;
    }
    public static int longestConsecutive(int[] nums) {
        int count = 1;
        if(nums.length ==0)
            return 0;
        int max_count = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i< nums.length; i++) {
            set.add(nums[i]);
        }
        for(int num: set) {
            if(!set.contains(num-1)){
                count=1;
                int current = num;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                max_count = Math.max(count, max_count);
            }
        }
        return max_count;

    }
}
