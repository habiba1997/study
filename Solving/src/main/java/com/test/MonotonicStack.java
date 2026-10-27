package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MonotonicStack {

    static List<Character> open = List.of('(', '[', '{');
    static List<Character> closed = List.of(')', ']', '}');


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (open.contains(c)) {
                stack.push(c);
            } else if (closed.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character openClosed = stack.pop();
                if ((openClosed == '[' && c != ']')
                        || (openClosed == '{' && c != '}')
                        || (openClosed == '(' && c != ')')) {
                    return false;
                }
            }
        }
        //  return true;
        return stack.isEmpty();
    }

    public static void mainIsValid(String[] args) {
        String[] tests = {
                "()", "()[]{}", "(]", "([)]",
                "{[]}", "((()))", "((()", "())",
                "", "]", "({[]})", "{{[()]}}"
        };

        boolean[] expected = {
                true, true, false, false,
                true, true, false, false,
                true, false, true, true
        };

        for (int i = 0; i < tests.length; i++) {
            boolean actual = isValid(tests[i]);

            System.out.printf(
                    "Test %d: %s%n",
                    i + 1,
                    actual == expected[i] ? "PASS" : "FAIL"
            );
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
//            0 sp i=`1
            result[i] = 0;
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }// 73 → 71 → 69 → 72

        return result;

    }

    public static void mainDailyTemperatures(String[] args) {
        int[][] tests = {
                {73, 74, 75, 71, 69, 72, 76, 73},
                {30, 40, 50, 60},
                {30, 60, 90},
                {90, 80, 70},
                {70, 70, 70},
                {70},
                {},
                {70, 65, 75, 60, 80}
        };

        int[][] expected = {
                {1, 1, 4, 2, 1, 1, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 0, 0},
                {0},
                {},
                {2, 1, 2, 1, 0}
        };

        for (int i = 0; i < tests.length; i++) {
            int[] actual = dailyTemperatures(tests[i]);

            boolean passed = Arrays.equals(actual, expected[i]);

            System.out.printf(
                    "Test %d: %s%nExpected: %s%nActual:   %s%n%n",
                    i + 1,
                    passed ? "PASS ✅" : "FAIL ❌",
                    Arrays.toString(expected[i]),
                    Arrays.toString(actual)
            );
        }
    }


    public static int[] nextGreaterElement(int[] nums) {
        Stack <Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {4, 5, 2, 10, 8},
                {2, 1, 3},
                {5, 4, 3, 2, 1},
                {1, 2, 3, 4},
                {2, 2, 3},
                {7},
                {},
                {3, 1, 4, 2, 5}
        };

        int[][] expected = {
                {5, 10, 10, -1, -1},
                {3, 3, -1},
                {-1, -1, -1, -1, -1},
                {2, 3, 4, -1},
                {3, 3, -1},
                {-1},
                {},
                {4, 4, 5, 5, -1}
        };

        for (int i = 0; i < tests.length; i++) {
            int[] actual = nextGreaterElement(tests[i]);

            boolean passed = Arrays.equals(actual, expected[i]);

            System.out.printf(
                    "Test %d: %s%nInput:    %s%nExpected: %s%nActual:   %s%n%n",
                    i + 1,
                    passed ? "PASS ✅" : "FAIL ❌",
                    Arrays.toString(tests[i]),
                    Arrays.toString(expected[i]),
                    Arrays.toString(actual)
            );
        }
    }
}
