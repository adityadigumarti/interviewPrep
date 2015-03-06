package com.google.interview.strings;

public class LongestCommonSubsequence {

    public static void main(String args[]) {
        System.out.println(new LongestCommonSubsequence().findLCS("GAC", "AGCAT"));
    }

    public String findLCS(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int maxLength = 0;

        int array[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            array[i][0] = 0;

        for (int j = 0; j <= len2; j++)
            array[0][j] = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                    if (array[i][j] > maxLength) {
                        maxLength = array[i][j];
                    }
                } else {
                    array[i][j] = Math.max(array[i][j - 1], array[i - 1][j]);
                }
            }
        }

        return findLongestSequence(array, s1, s2);

    }

    private String findLongestSequence(int[][] array, String s1, String s2) {
        int i = 1, j = 1;
        StringBuilder sb = new StringBuilder();

        while (i <= s1.length() && j <= s2.length()) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i++;
                j++;
            } else {
                if (array[i - 1][j] >= array[i][j - 1]) {
                    j++;
                } else {
                    i++;
                }

            }
        }

        return sb.toString();
    }
}
