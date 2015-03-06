package com.google.interviews.misc;

import java.util.Random;

public class RandomJava {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
            System.out.println(random.nextDouble());
            // System.out.println(random.nextDouble(20.0));
        }

    }

}
