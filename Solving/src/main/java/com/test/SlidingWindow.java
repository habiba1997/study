package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    public static int maxNumberOfConsecutive1s(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int zeroCount = k;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] != 1) {
                zeroCount--;
            }
            // shrink window
            while (zeroCount < 0) {
                if (nums[left] == 0) {
                    zeroCount++;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int totalFruit(int[] fruits) {
        int maxLength = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                Integer integer = map.get(fruits[left]);
                if (integer > 1) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                } else {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
//        int[] nums1 = {0, 0, 0, 0, 1, 1, 1, 0, 1};
//        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
//        int[] nums2 = {0, 0, 0, 0, 0, 0, 0, 0, 1};
//        int k = 2;
//        System.out.println(maxNumberOfConsecutive1s(nums1, k));  //6
//        System.out.println(maxNumberOfConsecutive1s(nums, k));  //7
//        System.out.println(maxNumberOfConsecutive1s(nums2, k)); //3

        int[][] tests = {
                {1, 2, 1},
                {0, 1, 2, 2},
                {1, 2, 3, 2, 2},
                {1, 2, 1, 2, 3, 2, 2},
                {3, 3, 3, 3},
                {1, 2, 3, 4, 5},
                {1, 1, 2, 3, 3, 2, 2},
                {},
                {1},
                {1, 2, 1, 3, 4, 3, 3}
        };

        int[] expected = {3, 3, 4, 4, 4, 2, 5, 0, 1, 4};

        for (int i = 0; i < tests.length; i++) {
            int actual = totalFruit(tests[i]);

            System.out.printf(
                    "Test %d: expected=%d, actual=%d, %s%n",
                    i + 1,
                    expected[i],
                    actual,
                    actual == expected[i] ? "PASS" : "FAIL"
            );
        }

    }
}
