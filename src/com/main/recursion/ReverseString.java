package com.main.recursion;

public class ReverseString {
    private static String reverseString(String s) {
        return helper(s, s.length() - 1,"");
    }

    private static String helper(String s, int index, String ans) {
        if (index == -1) {
            return ans;
        }

        ans += s.charAt(index);
        return helper(s, index - 1, ans);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcdefghijk"));
    }
}
