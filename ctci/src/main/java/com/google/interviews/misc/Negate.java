package com.google.interviews.misc;

public class Negate {

    public static int negate(int a) {
        int neg = 0;
        int d = a < 0 ? 1 : -1;
        while (a != 0) {
            neg += d;
            a += d;
        }
        return neg;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(negate(10));

    }

}
