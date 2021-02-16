package com.main.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    Map<Integer, Integer> memo = new HashMap<>();

    private int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }

    private int recursiveWithMemo(int index, String s) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (index == s.length() - 1) {
            return 1;
        }

        int result = recursiveWithMemo(index + 1, s);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            result += recursiveWithMemo(index + 2, s);
        }

        memo.put(index, result);
        return result;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("256"));
    }
}
