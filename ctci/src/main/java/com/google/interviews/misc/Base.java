package com.google.interviews.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base extends Super {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Number> ints = Arrays.<Number> asList(1, 2, 3);
        List<? super Integer> nums = new ArrayList<Number>();
        // nums.set(2, 3.14); // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!

    }

}
