package com.main.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FibinocciDP {
    public static void main(String[] args) {
        FibinocciDP fibinocciDP = new FibinocciDP();
//        System.out.println(fibinocciDP.fibMemo(10));
        System.out.println(fibinocciDP.fibTabu(10));
    }

    //Top-down approach
    private int fibMemo(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return fibMemo(n, cache);
    }

    private int fibMemo(int n, Map<Integer, Integer> cache) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        int result = fibMemo(n-1, cache) + fibMemo(n-2, cache);
        cache.put(n, result);
        return result;
    }

    //Bottom-up approach
    private int fibTabu(int n) {
        int[] table = new int[n+1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i < table.length; i++) {
            table[i] = table[i-1] + table[i-2];
        }

        return table[n];
    }
}
