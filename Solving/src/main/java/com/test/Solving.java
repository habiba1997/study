package com.test;

import java.util.Arrays;

public class Solving {

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        return climbStairs(n - 1)
                + climbStairs(n - 2);
    }


    public static void mainclimbStairs(String[] args) {
        int[] tests = {1, 2, 3, 4, 5, 6, 7, 10};
        int[] expected = {1, 2, 3, 5, 8, 13, 21, 89};

        for (int i = 0; i < tests.length; i++) {
            int actual = climbStairs(tests[i]);

            System.out.printf(
                    "Test %d: %s | Expected: %d, Actual: %d%n",
                    i + 1,
                    actual == expected[i] ? "PASS" : "FAIL",
                    expected[i],
                    actual
            );
        }
    }

    public static int rob(int[] nums) {
        return rob(nums, 0);
    }

    public static int rob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        int current = nums[index] + rob(nums, index + 2);
        int skip = rob(nums, index + 1);
        return Math.max(current, skip);
    }

    public static void main1(String[] args) {
        int[][] tests = {
                {1, 2, 3, 1},
                {2, 7, 9, 3, 1},
                {5, 1, 1, 5},
                {2, 1, 1, 2},
                {10},
                {1, 2},
                {0, 0, 0},
                {},
                {4, 10, 3, 1, 5}
        };

        int[] expected = {4, 12, 10, 4, 10, 2, 0, 0, 15};

        for (int i = 0; i < tests.length; i++) {
            int actual = rob(tests[i]);

            System.out.printf(
                    "Test %d: %s | Expected: %d, Actual: %d%n",
                    i + 1,
                    actual == expected[i] ? "PASS" : "FAIL",
                    expected[i],
                    actual
            );
        }
    }


    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int before = 1;
        int after = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = before;
            before = before * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * after;
            after = after * nums[i];
        }
        return result;
    }

    public static void main2(String[] args) {
        int[][] tests = {
                {1, 2, 3, 4},
                {-1, 1, 0, -3, 3},
                {2, 3},
                {0, 0, 2, 3},
                {1, 1, 1, 1},
                {-2, -3, 4},
                {5, 0, 2},
                {3, 4, 5}
        };

        int[][] expected = {
                {24, 12, 8, 6},
                {0, 0, 9, 0, 0},
                {3, 2},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {-12, -8, 6},
                {0, 10, 0},
                {20, 15, 12}
        };

        for (int i = 0; i < tests.length; i++) {
            int[] actual = productExceptSelf(tests[i]);

            System.out.printf(
                    "Test %d: %s | Expected: %s | Actual: %s%n",
                    i + 1,
                    Arrays.equals(actual, expected[i]) ? "PASS" : "FAIL",
                    Arrays.toString(expected[i]),
                    Arrays.toString(actual)
            );
        }
    }

    public static int subarraySum(int[] nums, int k) {

        int left = 0;
        int sum = 0;
        int subarraySum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            if (sum >= k) {
                if (sum == k) {
                    subarraySum += 1;
                }
                sum -= nums[left];
                left++;
            }
        }
        if (sum == k) {
            subarraySum += 1;
        }
        return subarraySum;
    }


    public static void main(String[] args) {
        int[][] tests = {
                {1, 1, 1},
                {1, 2, 3},
                {1, -1, 0},
                {3, 4, 7, 2, -3, 1, 4, 2},
                {0, 0, 0},
                {1},
                {1},
                {},
                {-1, -1, 1},
                {2, 2, 2}
        };

        int[] k = {2, 3, 0, 7, 0, 1, 2, 0, 0, 4};
        int[] expected = {2, 2, 3, 4, 6, 1, 0, 0, 1, 2};

        for (int i = 0; i < tests.length; i++) {
            int actual = subarraySum(tests[i], k[i]);

            System.out.printf(
                    "Test %d: %s | Expected: %d, Actual: %d%n",
                    i + 1,
                    actual == expected[i] ? "PASS" : "FAIL",
                    expected[i],
                    actual
            );
        }
    }

}
