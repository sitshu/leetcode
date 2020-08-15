package com.company.array;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        int[] result = productExceptSelf(array);

    }
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] from_0 = new int[length];
        int[] till_n = new int[length];
        int[] result = new int[length];
        from_0[0] = 1;
        till_n[length-1] = 1;

        for(int i=1; i < length ; i++) {
            from_0[i] = from_0[i-1]*nums[i-1];
        }

        for(int i = length-2; i >= 0; i--) {
            till_n[i] = till_n[i+1] * nums[i+1];
        }

        for(int i=0; i< length; i++) {
            result[i] = from_0[i] * till_n[i];
        }
        return result;
    }


}
