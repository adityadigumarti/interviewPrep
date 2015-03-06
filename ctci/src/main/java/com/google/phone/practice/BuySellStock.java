package com.google.phone.practice;

public class BuySellStock {

    public static void main(String args[]) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695 };
        int[] arr = new BuySellStock().getBuySellDays(prices);

        System.out.println(prices[arr[0]]);
        System.out.println(prices[arr[1]]);

    }

    public int[] getBuySellDays(int[] arr) {
        int buyIndex = 0;
        int sellIndex = 0;
        int currentBuyIndex = 0;
        int currentSellIndex = 0;
        int maxProfit = -1;
        int currentProfit = -1;
        int[] buySellIndex = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[currentBuyIndex]) {
                currentBuyIndex = i;
                currentSellIndex = i;
            }

            if (arr[i] > arr[currentSellIndex]) {
                currentSellIndex = i;

                // if (arr[currentSellIndex] - arr[currentBuyIndex] > currentProfit) {
                currentProfit = arr[currentSellIndex] - arr[currentBuyIndex];

                if (currentProfit > maxProfit) {
                    buyIndex = currentBuyIndex;
                    sellIndex = currentSellIndex;
                    maxProfit = currentProfit;
                }
            }

        }

        buySellIndex[0] = buyIndex;
        buySellIndex[1] = sellIndex;

        return buySellIndex;

    }

}
