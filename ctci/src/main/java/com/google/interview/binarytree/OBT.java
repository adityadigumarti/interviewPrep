package com.google.interview.binarytree;

public class OBT {

    public static void main(String args[]) {
        int[] array = {10, 12, 20 };
        int[] probability = {34, 8, 50 };
        System.out.println(new OBT().findOptimalBinaryTree(array, probability));
    }

    public int findOptimalBinaryTree(int[] array, int[] probability) {
        int length = array.length;
        int root, left, right;
        int[][] value = new int[length][length];
        int min = Integer.MAX_VALUE;
        int j = 0;

        for (int i = 0; i < length; i++) {
            value[i][i] = probability[i];
        }

        for (int l = 1; l < length; l++) {
            for (int i = 0; i + l < length; i++) {
                j = i + l;
                min = Integer.MAX_VALUE;
                for (int r = i; r <= j; r++) {
                    root = findValue(r, r, value);
                    left = findValue(i, r - 1, value);
                    right = findValue(r + 1, j, value);

                    if (root + 2 * left + 2 * right < min) {
                        min = root + 2 * left + 2 * right;
                    }
                }

                value[i][j] = min;
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.println();
            for (j = 0; j < length; j++)
                System.out.print(value[i][j] + "   ");
        }

        return value[0][length - 1];

    }

    public int findValue(int i, int j, int[][] value) {
        if (j < i) {
            return 0;
        }

        return value[i][j];
    }

}
