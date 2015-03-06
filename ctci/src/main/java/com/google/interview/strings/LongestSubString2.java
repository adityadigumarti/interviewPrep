package com.google.interview.strings;

public class LongestSubString2 {

    public static void main(String args[]) {
        System.out.println(new LongestSubString2().findLongestSubstring("ABCD", "BCDEF"));
    }

    public String findLongestSubstring(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int maxLength = 0;
        int endIndex = 0;

        int[][] array = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;

                    if (array[i][j] > maxLength) {
                        maxLength = array[i][j];
                        endIndex = i - 1;
                    }
                }

        return s1.substring(endIndex - maxLength + 1, endIndex + 1);
    }
}
