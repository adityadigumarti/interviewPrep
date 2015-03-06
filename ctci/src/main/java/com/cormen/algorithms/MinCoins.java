package com.cormen.algorithms;

public class MinCoins {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 0; i <= 100; i++)
            System.out.println(array[i]);

    }

    public static int findMinCoins(final int[] coins, final int sum) {
        int[] minCoins = new int[sum + 1];
        for (int s = 1; s <= sum; s++) {
            minCoins[s] = Integer.MAX_VALUE - 1;
        }

        for (int s = 1; s <= sum; s++) {
            for (int coin : coins) {
                if (s >= coin) {
                    minCoins[s] = Math.min(minCoins[s], minCoins[s - coin] + 1);
                }
            }
        }
        return minCoins[sum];
    }

}
