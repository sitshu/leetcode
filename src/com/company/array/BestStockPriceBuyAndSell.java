package com.company.array;

public class BestStockPriceBuyAndSell {



    public static void main(String[] args) {
        // write your code here

        int[] array = new int[]{7,1,5,3,6,4};

        int res = maxProfit(array);
        System.out.println(res);

    }

    private static int maxProfit(int[] array) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i< array.length; i++) {
            if(minPrice > array[i])
                minPrice = array[i];
            else if(maxProfit < array[i] - minPrice)
                maxProfit = array[i] - minPrice;
        }
        return maxProfit;


    }
}
