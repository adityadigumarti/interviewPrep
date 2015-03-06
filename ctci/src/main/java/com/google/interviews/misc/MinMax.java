package com.google.interviews.misc;

public class MinMax {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7 };
        minMax(array);
    }

    public static void minMax(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;

        while (i <= array.length - 2) {
            System.out.println("***" + i);

            if (array[i] < array[i + 1]) {
                if (array[i] < min) {
                    min = array[i];
                }

                if (array[i + 1] > max) {
                    max = array[i + 1];
                }
            } else {
                if (array[i + 1] < min) {
                    min = array[i + 1];
                }

                if (array[i] > max) {
                    max = array[i];
                }
            }

            i = i + 2;

            System.out.println(i);

            if (i == array.length - 1) {
                if (array[i] < min) {
                    min = array[i];
                }

                if (array[i] > max) {
                    max = array[i];
                }
            }
        }

        System.out.println(String.format("Max %d Min %d", max, min));
    }

}
