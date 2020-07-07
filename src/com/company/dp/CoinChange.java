package com.company.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,5};
        int result = coinChange(array, 11);
        System.out.println(result);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] amountarray = new int[amount + 1];
        Arrays.fill(amountarray, amount + 1);
        amountarray[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    amountarray[i] = Math.min(amountarray[i - coins[j]] + 1, amountarray[i]);
                }
            }
        }
        return amountarray[amount] > amount ? -1 : amountarray[amount];
    }
}
