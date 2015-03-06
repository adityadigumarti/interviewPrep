package com.google.phone.practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {

    public static void main(String args[]) {
        System.out.println(new StringPermutations().findAllPermutations("cat"));
    }

    public Set<String> findAllPermutations(String s) {
        Set<String> list = null;

        if (s.length() == 1) {
            list = new HashSet<String>();
            list.add(s);
            return list;
        }

        list = findAllPermutations(s.substring(1));

        return combine(s.substring(0, 1), list);
    }

    private Set<String> combine(String letter, Set<String> list) {
        Set<String> permutations = new HashSet<String>();

        for (String s : list) {
            permutations.addAll(concatAtAllPositions(letter, s));
        }

        return permutations;
    }

    private Set<String> concatAtAllPositions(String letter, String string) {
        Set<String> permutations = new HashSet<String>();
        StringBuilder sb = null;

        for (int i = 0; i <= string.length(); i++) {
            permutations.add(new StringBuilder(string).insert(i, letter).toString());
        }

        return permutations;
    }
}
