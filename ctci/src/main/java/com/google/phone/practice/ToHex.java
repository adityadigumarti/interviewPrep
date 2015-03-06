package com.google.phone.practice;

import java.util.HashMap;
import java.util.Map;

public class ToHex {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getHexadecimal(31));
        System.out.println(Integer.toHexString(31));

    }

    private static Map<Integer, String> hexMap = populateHexMap();

    private static Map populateHexMap() {
        Map<Integer, String> hexMap = new HashMap<Integer, String>();

        hexMap.put(10, "A");
        hexMap.put(11, "B");
        hexMap.put(12, "C");
        hexMap.put(13, "D");
        hexMap.put(14, "E");
        hexMap.put(15, "F");

        return hexMap;
    }

    public static String getHexadecimal(int number) {
        StringBuilder hexNumber = new StringBuilder();
        int remainder = 0;

        while (number != 0) {
            remainder = number % 16;
            if (remainder < 10) {
                hexNumber.append(remainder);
            } else {
                hexNumber.append(hexMap.get(remainder));
            }

            number = number / 16;
        }

        return hexNumber.reverse().toString();

    }

}
