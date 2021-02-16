package com.main.linked_lists;

/*
 * Given a string s and a dictionary containing a list of words, write a function to break the string completely into valid words.
 * Print all such possible sentences. The same word in the dictionary may be reused multiple times.
 */

import java.util.*;

import static java.util.Arrays.asList;

public class ValidWordsFromString {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.addAll(asList("cat", "cats", "and", "sand", "dog", "dogs"));
        validWordsFromString("catsanddogs", dict);
    }

    private static void validWordsFromString(String s, Set<String> dict) {
        if (s.isEmpty() || dict.size() == 0) {
            return;
        }
        validWordsFromString(s, dict, new ArrayList<>());
    }

    private static void validWordsFromString(String s, Set<String> dict, List<String> partial) {
        if (s.length() == 0) {
            System.out.println(Arrays.toString(partial.toArray()));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i+1);
            if (dict.contains(sub)) {
                partial.add(sub);
                validWordsFromString(s.substring(i+1), dict, partial);
                partial.remove(partial.size() - 1);
            }
        }
    }
}
