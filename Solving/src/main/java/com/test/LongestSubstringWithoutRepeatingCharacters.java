package com.test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


//    public int lengthOfLongestSubstring(String s) {
//        int length = 0;
//        int lengthOfLongestSubstring = 0;
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!set.contains(s.charAt(i))) {
//                set.add(s.charAt(i));
//                length++;
//            } else {
//                lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, length);
//                length = 0;
//                set = new HashSet<>();
//            }
//        }
//        return Math.max(lengthOfLongestSubstring, length);
//    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s1 = "abcabcbb"; // 3
        String s2 = "bbbb"; //1
        String s3 = "pwwkew"; //3
        String s4 = "dvdf"; //3
        int length = solution.lengthOfLongestSubstring(s1);
        System.out.println("Length of longest substring without repeating characters: " + length);
        length = solution.lengthOfLongestSubstring(s2);
        System.out.println("Length of longest substring without repeating characters: " + length);
        length = solution.lengthOfLongestSubstring(s3);
        System.out.println("Length of longest substring without repeating characters: " + length);
        length = solution.lengthOfLongestSubstring(s4);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}
