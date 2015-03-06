package com.google.interview.strings;

public class LongestPalindrome2 {

    public static void main(String args[]) {
        System.out.println(new LongestPalindrome2().findLongstPalindrome("ABCSBA"));
    }

    public String findLongstPalindrome(String s) {
        int length = s.length();
        String palindrome = s.substring(0, 1);

        boolean array[][] = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            array[i][i] = true;
        }

        int j = 0;

        for (int l = 1; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                j = i + l;

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 1) {
                        if (array[i + 1][j - 1]) {
                            array[i][j] = true;
                        } else {
                            array[i][j] = false;
                        }
                    } else {
                        array[i][j] = true;
                    }
                } else {
                    array[i][j] = false;
                }

                if (array[i][j]) {
                    palindrome = s.substring(i, j + 1);
                }
            }
        }

        return palindrome;

    }

}
