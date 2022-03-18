package com.main.greedy;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1}; //where i is the day
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return -1;
        }

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }
}
