package com.company.array;

import java.util.PriorityQueue;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] array = new int[]{4,5,6,7,0,1,2};
        int result = search(array, 2);
        System.out.println(result);
    }
    public static int search(int[] nums, int target) {

        if(nums.length == 1 && target!= nums[0])
            return -1;

        int min = findMin(nums);
        if( min == -1 || nums[min] == target)
            return min;

        if(target > nums[nums.length-1])
            return binarySearch(nums, 0, min-1, target);
        else
            return binarySearch(nums, min+1, nums.length-1, target);

    }

    public static int binarySearch(int []nums, int low, int high, int target) {

        while(low <= high) {
            int mid = low + (high -low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid +1;

        }

        return -1;

    }

    public  static int findMin(int[] nums) {
        int low =0, high=nums.length-1 , mid=0;
        if(nums.length == 0)
            return -1;
        if(nums[high] >= nums[low])
            return low;

        while(high>low) {
            mid = low + (high-low)/2;

            if(nums[mid] > nums[mid+1])
                return mid+1;
            if(nums[mid] < nums[mid-1])
                return mid;

            if(nums[mid] > nums[0])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;

    }
}
