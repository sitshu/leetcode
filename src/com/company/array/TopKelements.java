package com.company.array;

import java.util.*;

public class TopKelements {
    public static void main(String[] args) {
        // write your code here

         int[] array = new int[]{1,1,1,2,2,3};


        int[] list= topKFrequent(array, 2);

    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for(int i = 0; i< nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2)-> map.get(n1) - map.get(n2));

        for(int n: map.keySet()) {

            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }

        int[] top = new int[k];
        for(int i = k-1; i>=0; --i ){
            top[i]= heap.poll();
        }
        return top;
    }
}
