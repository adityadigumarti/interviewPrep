package com.google.interviews.misc;

public class NumZerosInFactorial {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findFactorial(10));
        System.out.println(countFactZeros(10));
    }

    public static int countFactZeros(int num) {
        int count = 0;

        if (num < 0) {
            return -1;
        }

        for (int i = 5; num / i > 0; i = i * 5) {
            System.out.println(i + "   " + count + "   " + num / i);
            count += num / i;
        }

        return count;
    }

    public static long findFactorial(long n) {
        if (n == 1) {
            return 1;
        }

        return n * findFactorial(n - 1);
    }

}
