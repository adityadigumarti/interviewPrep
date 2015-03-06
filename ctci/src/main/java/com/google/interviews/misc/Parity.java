package com.google.interviews.misc;

public class Parity {

    public static String parity(String msg) {
        String parityStr = null;
        int n = msg.hashCode();

        System.out.println(n);

        switch (n % 2) {
            case 0:
                parityStr = "even";
                break;
            case 1:
                parityStr = "odd";
                break;
        }

        return parityStr;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(parity("Aditya"));
        System.out.println(parity("Kiran"));

    }

}
