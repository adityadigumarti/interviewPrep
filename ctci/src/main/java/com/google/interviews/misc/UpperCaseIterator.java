package com.google.interviews.misc;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Create a class that implements the Iterator interface and whose constructor
 * takes a List<Character> as a parameter. The iterator shall return each character
 * in the list that is an upper case character.
 * Iterator javadoc screen shot: http://www.screencast.com/t/K0cbBIMS
 * You may use the Character.isUpperCase() static method to check members of the list.
 * You may not use the input.iterator().
 * 
 * Example: 'a', 'X', 'b', 'Y', 'c', 'Z', 'd'
 * 
 * hasNext() ---> true
 * next() ---> 'X'
 * hasNext() ---> true
 * next() ---> 'Y'
 * hasNext() ---> true
 * next() ---> 'Z'
 * hasNext() ---> false
 */

public class UpperCaseIterator implements Iterator<Character> {

    private List<Character> list;
    private int currentIndex = 0;
    private int previousIndex = -1;

    public UpperCaseIterator(List<Character> input) {
        currentIndex = 0;
        this.list = input;

    }

    public boolean hasNext() {

        return currentIndex < list.size();

    }

    public Character next() {
        if (currentIndex == list.size()) {
            throw new NoSuchElementException();
        }

        if (!Character.isUpperCase(list.get(currentIndex))) {
            getNextCharacter();
        }

        previousIndex = currentIndex;
        currentIndex++;

        getNextCharacter();

        return list.get(previousIndex);
    }

    private void getNextCharacter() {
        while (currentIndex < list.size() && !Character.isUpperCase(list.get(currentIndex))) {
            currentIndex++;
        }
    }

    public void remove() {
        if (previousIndex == -1) {
            throw new IllegalStateException();
        }

        list.remove(previousIndex);
        currentIndex--;

        previousIndex = -1;
    }
}
