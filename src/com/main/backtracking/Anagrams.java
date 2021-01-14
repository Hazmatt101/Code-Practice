package com.main.backtracking;

import java.util.Arrays;

/*
 * Given a string, write a function to print out all its anagrams.
 */
public class Anagrams {
    public static void main(String[] args) {
        generateAnagrams("string");
    }

    private static void generateAnagrams(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        generateAnagrams(sArr, new boolean[s.length()], new char[s.length()], 0);
    }

    private static void generateAnagrams(char[] sArr, boolean[] used, char[] partial, int index) {
        //base case
        if (index == sArr.length) {
            System.out.println(new String(partial));
            return;
        }
        for (int i = 0; i < sArr.length; i++) {
            if (!used[i] && !(i > 0 && sArr[i] == sArr[i-1] && !used[i-1])) {
                used[i] = true;
                partial[index] = sArr[i];
                generateAnagrams(sArr, used, partial, index + 1);
                used[i] = false;
            }
        }
    }
}
