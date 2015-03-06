package com.google.interview.interesting;

public class NumberPalindrome {

    public static void main(String args[]) {
        System.out.println(isPalindrome(33222331));
    }

    public static boolean isPalindrome(int number) {
        boolean isPalindrome = true;

        int div = 1;
        int left = 0, right = 0;

        while (number / div > 10) {
            div = div * 10;
        }

        while (number > 9) {
            left = number / div;
            right = number % 10;

            if (left != right) {
                return false;
            }

            number = number % div;
            number = number / 10;

            div = div / 100;

        }

        return isPalindrome;

    }

}
