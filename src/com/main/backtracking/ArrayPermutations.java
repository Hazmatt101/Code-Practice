package com.main.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutations {
    private static List<List<Integer>> output = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        generatePermutations(nums);
        System.out.println(output);
    }

    private static void generatePermutations(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        generatePermutations(nums, new ArrayList<>(), used);
    }

    private static void generatePermutations(int[] nums, List<Integer> partial, boolean[] used) {
        if (partial.size() == nums.length) {
            output.add(new ArrayList<>(partial));
            return;
        }

        //generate candidates
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                partial.add(nums[i]);
                generatePermutations(nums, partial, used);
                used[i] = false;
                partial.remove(partial.size() - 1);
            }
        }
    }
}
