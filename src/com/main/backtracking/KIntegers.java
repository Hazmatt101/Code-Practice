package com.main.backtracking;

import java.util.HashSet;

/*
 * Given an input array and an integer 'K' which is at most the size of the array, generate all the ways we
 * can choose K integers from the array.
 */
public class KIntegers {
    public static void main(String[] args) {
        int[] inputArr = {1, 2, 3, 4, 5};
        int k = 3;

//        KIntegers.generateCombinations(inputArr, k, new HashSet<>(), 0);
        generateCombinationsAlternate(inputArr, k, new HashSet<>(), 0);
    }

    public static void generateCombinations(int[] inputArr, int k, HashSet<Integer> partial, int start) {
        //base case
        if (partial.size() == k) {
            System.out.println(partial);
            return;
        }

        //generate candidates
        if (start == inputArr.length) {
            return;
        }
        for (int i = start; i < inputArr.length; i++) {
            partial.add(inputArr[i]);
            generateCombinations(inputArr, k, partial, i + 1);
            partial.remove(inputArr[i]);
        }
    }

    public static void generateCombinationsAlternate(int[] inputArr, int k, HashSet<Integer> partial, int index) {
        if (partial.size() == k) {
            System.out.println(partial);
            return;
        }

        if (index == inputArr.length) {
            return;
        }
        partial.add(inputArr[index]);
        generateCombinationsAlternate(inputArr, k, partial, index + 1);
        partial.remove(inputArr[index]);
        generateCombinationsAlternate(inputArr, k, partial, index + 1);
    }
}
