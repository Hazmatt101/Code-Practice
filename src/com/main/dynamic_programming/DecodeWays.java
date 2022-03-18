package com.main.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    Map<Integer, Integer> memo = new HashMap<>();

    private int numDecodings(String s, boolean recursive) {
        if (recursive) {
            return recursiveWithMemo(0, s);
        } else {
            return recursiveWithTable(s);
        }
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

    private int recursiveWithTable(String s) {  //'101123' => 5
        int[] table = new int[s.length() + 1];
        table[0] = 1;
        table[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < table.length; i++) {
            if (s.charAt(i - 1) != '0') {
                table[i] = table[i - 1];
            }

            int num = Integer.parseInt(s.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                table[i] += table[i - 2];
            }
        }

        return table[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("101123", false));
    }
}
