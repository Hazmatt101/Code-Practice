package com.main.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/*
 * Given coins of value 1, 5, 10, 25 and a sum, what is the minimum number of coins needed to reach the sum?
 */
public class MinimumCoinsToMakeChange {
    public static int minCoinsChangeTopDown(int amount, int[] coins, Map<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            }

            int newAmount = minCoinsChangeTopDown(amount - coins[i], coins, memo);

            if (newAmount < min) {
                min = newAmount;
            }
        }

        if (min != Integer.MAX_VALUE) {
            min = min + 1;
        }

        memo.put(amount, min);
        return min;
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        System.out.println(minCoinsChangeTopDown(68, coins, new HashMap<>()));
    }
}
