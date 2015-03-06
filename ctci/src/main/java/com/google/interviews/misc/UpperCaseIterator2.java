package com.google.interviews.misc;

import java.util.List;
import java.util.NoSuchElementException;

public class UpperCaseIterator2 {

    private List<Character> list;
    private boolean allowRemove = false;
    private int index = 0;

    public UpperCaseIterator2(List<Character> list) {
        this.list = list;
        allowRemove = false;
        index = 0;
    }

    public Character getNext() {
        Character next = null;

        while (index < list.size() && !Character.isUpperCase(list.get(index))) {
            index++;
        }

        if (index < list.size()) {
            next = list.get(index);
        }

        return next;
    }

    public boolean hasNext() {
        return getNext() != null;
    }

    public Character next() {
        Character next = null;

        if (index >= list.size()) {
            throw new NoSuchElementException();
        }

        if (Character.isUpperCase(list.get(index))) {
            next = list.get(index);
        } else {
            next = getNext();
            if (next == null) {
                throw new NoSuchElementException();
            }
        }

        index++;
        allowRemove = true;

        return next;

    }

    public void remove() {
        if (!allowRemove) {
            throw new IllegalStateException();
        }

        list.remove(index - 1);
        allowRemove = false;
    }

}
