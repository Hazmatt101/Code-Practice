package com.main.backtracking;
/*
 * Given a list of numbers, and a target number, print all the unique combinations in candidates
 * where the candidate numbers sum to the target. You can use each list element only once.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//This is a variation of the coins problem.
public class ComboSum {
    public static void main(String[] args) {
        int[] inputArr = {10, 1, 2, 7, 6, 1, 5};
        comboSum(inputArr, 8);
    }

    private static void comboSum(int[] nums, int target) {
        Arrays.sort(nums);
        comboSum(nums, target, 0, new ArrayList<>(), 0);
    }

    private static void comboSum(int[] nums, int target, int sum, List<Integer> partial, int start) {
        if (sum == target) {
            System.out.println(Arrays.toString(partial.toArray()));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int c = nums[i];
            if (sum + c > target || i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            partial.add(c);
            comboSum(nums, target, sum + c, partial, i + 1);
            partial.remove(partial.size() - 1);
        }
    }
}
