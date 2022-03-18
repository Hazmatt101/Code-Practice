//package com.main.dynamic_programming;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///*
// * Problem description:
// * Given a set of items, each with a weight and a value, determine the number of each item to include in a collection so
// * that the total weight is less than or equal to a given limit and the total value is as large as possible.
// */
//public class KnapsackProblem {
//    public static void main(String[] args) {
//        int[][] itemTable = {
//                {3000, 4},
//                {1500, 3},
//                {800, 1},
//                {1000, 2},
//        };
//        int[][] answers = KnapsackProblem.solveKnapsackProblemBottomUp(7, itemTable);
//        for (int i = 0; i < answers.length; i++) {
//            System.out.println(answers[i][0]);
//        }
//    }
//
//    private static int[][] solveKnapsackProblemBottomUp(int sackCapacity, int[][] itemTable) {
//        int[] table = new int[sackCapacity + 1];
//        Arrays.fill(table, -1);
//        table[0] = 0;
//
//        for (int i = 1; i < table.length; i++) {
//            if (table[i] != -1) {
//                continue;
//            }
//
//            int itemCount = 0;
//            int maxValue = -1;
//            for (int j = 0; j < itemTable.length; j++) {
//                int remainingCapacity = sackCapacity - itemTable[j][1];
//                if (remainingCapacity >= 0) {
//                    maxValue = Math.max(maxValue, itemTable[j][0]);
//                }
//            }
//            table[i] = maxValue;
//            if (maxValue == -1) {
//                System.out.println("Nothing fits in bag of size " + i);
//            }
//        }
//
//        int[][] solution = itemTable;
//        for (int[] array : solution) {
//
//        }
//    }
//}
