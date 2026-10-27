package com.test;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMost2DistinctCharacters {


    public static void main(String[] args) {
        LongestSubstringWithAtMost2DistinctCharacters solution = new LongestSubstringWithAtMost2DistinctCharacters();
        String s1 = "eceba"; // 3
        String s2 = "ccaabbb"; //5
        String s3 = "aaaa"; //4
        int length = solution.lengthOfLongestSubstringWithAtMost2DistinctCharacters(s1);
        System.out.println("Length of longest substring without repeating characters: " + length);
        length = solution.lengthOfLongestSubstringWithAtMost2DistinctCharacters(s2);
        System.out.println("Length of longest substring without repeating characters: " + length);
        length = solution.lengthOfLongestSubstringWithAtMost2DistinctCharacters(s3);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }


    private int lengthOfLongestSubstringWithAtMost2DistinctCharacters(String s) {
        int maxLength = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            map.put(current, map.getOrDefault(current, 0) + 1);

            while (map.size() > 2) {
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    //    private int lengthOfLongestSubstringWithAtMost2DistinctCharacters(String s1) {
//        int maxlength = 0;
//        int left = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int right = 0; right < s1.length(); right++) {
//
//            while (map.size() == 2 && !map.containsKey(s1.charAt(right))) {
//                left = right - 1;
//                char key = s1.charAt(left);
//                int value = map.get(key);
//                map = new HashMap<>();
//                map.put(key, value);
//                map.put(s1.charAt(right), right);
//            }
//
//            map.put(s1.charAt(right), right);
//            maxlength = Math.max(maxlength, right - left + 1);
//        }
//        return maxlength;
//    }
}
