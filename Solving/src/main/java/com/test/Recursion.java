package com.test;

public class Recursion {

    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative input");
        }

        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    /*
    Given a string, reverse it using recursion.

    Example:
    "hello" → "olleh"
     */

    String reverseString(String str) {
        if (str.length() == 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        String str = "hello";
        String reversedStr = recursion.reverseString(str);
        System.out.println("Original string: " + str);
        System.out.println("Reversed string: " + reversedStr);
    }
}
