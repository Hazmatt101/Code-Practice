package com.main.arrays;

/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 */

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationDivisibleBy60 {
    public static void main(String[] args) {
        int[] times = {30, 20, 150, 100, 40};
        System.out.println(getPairsOfSongs(times));
    }

    private static int getPairsOfSongs(int[] times) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int time : times) {
            if (time % 60 == 0) {
                count += map.getOrDefault(time, 0);
            } else {
                count += map.getOrDefault(60 - (time % 60), 0);
            }
            map.put(time % 60, map.getOrDefault(time % 60, 0) + 1);
        }

        return count;
    }
}
