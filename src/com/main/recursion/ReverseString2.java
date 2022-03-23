package com.main.recursion;

public class ReverseString2 {

    private static char[] reverseString(char[] s) {
        return helper(s, 0, s.length - 1);
    }

    private static char[] helper(char[] s, int left, int right) {
        if (s == null || s.length < 2) {
            return s;
        }
        if (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            helper(s, left + 1, right - 1);
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(reverseString(new char[]{'h', 'e', 'l', 'l', 'o'}));
    }
}
