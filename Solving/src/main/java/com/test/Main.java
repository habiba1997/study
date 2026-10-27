package com.test;

import java.util.HashSet;
import java.util.List;

public class Main {

    // Given an array of integers, return two indices whose values add up to a target.
    public Integer[] returnTwoIndicesWhoseValuesAddToTarget() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        HashSet<Integer> set = new HashSet<>(arr);
        int target = 7;

        for (Integer i : set) {
            if (set.contains(target - i)) {
                return new Integer[]{i, target - i};
            }
        }
        return null;
    }

    /*
    Given a string, determine whether it is a palindrome.

    Ignore spaces and character casing.

    Example:

    "Race car" → true
    "hello" → false
     */
    // I would use two pointers, one starting at the beginning of the string and one at the end.
    // I would compare the characters at both positions, ignoring spaces and casing.
    // If they are different, I return false immediately.
    // Otherwise, I move both pointers toward the center.
    // If they meet without finding a mismatch, I return true.
    boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            while (left < right && str.charAt(left) == ' ') {
                left++;
            }

            while (left < right && str.charAt(right) == ' ') {
                right--;
            }

            // "As soon as I find a mismatch, I can return false immediately."
            if (Character.toLowerCase(str.charAt(left))
                    != Character.toLowerCase(str.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /*
    Base case: if the string has length 0 or 1, it is already reversed.
    Smaller problem: reverse everything except the first character, then put the first character at the end
    The Java substring() method extracts a specific portion of a string and returns it as a new string
    substring(int beginIndex)	Extracts from the beginIndex (inclusive) to the end of the string
     */
    String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }

}