package com.google.interviews.misc;

import java.util.BitSet;

public class BitSetExample {

    public static void main(String args[]) {
        BitSet bitset = new BitSet(126);
        String str = "kiran";
        char ch;
        boolean isUnique = true;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);

            if (bitset.get(ch)) {
                isUnique = false;
                break;
            } else {
                bitset.set(ch);
            }
        }

        System.out.println(isUnique);
    }

}
