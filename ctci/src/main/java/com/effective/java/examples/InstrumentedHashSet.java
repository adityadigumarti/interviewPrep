package com.effective.java.examples;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        System.out.println("In Add");
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        System.out.println("In AddAll");
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String args[]) {
        // InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
        // s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));

        int a[] = {1, 2, 3, 4, 5, 6, 7, 8 };
        List list = intArrayAsList(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    static List<Integer> intArrayAsList(final int[] a) {
        if (a == null)
            throw new NullPointerException();
        return new AbstractList<Integer>() {
            public Integer get(int i) {
                return a[i]; // Autoboxing (Item 5)
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val; // Auto-unboxing
                return oldVal; // Autoboxing
            }

            public int size() {
                return a.length;
            }
        };
    }

}
