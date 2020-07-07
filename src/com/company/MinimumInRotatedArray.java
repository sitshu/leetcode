package com.company;

public class MinimumInRotatedArray {


    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,1,2};
        int result = findMin(array);
        System.out.println(result);
    }

    public static int findMin(int[] nums) {
        int low =0, high=nums.length-1 , mid=0;

        if(nums[high] >= nums[low])
            return nums[low];

        while(high>low) {
            mid = low + (high-low)/2;

            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            if(nums[mid] < nums[mid-1])
                return nums[mid];

            if(nums[mid] > nums[0])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;

    }
}
