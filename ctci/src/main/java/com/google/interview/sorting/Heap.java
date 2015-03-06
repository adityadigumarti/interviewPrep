package com.google.interview.sorting;

import java.util.ArrayList;

public class Heap<T> {

    private int size = 0;

    private static final int MAX_SIZE = 128;
    private ArrayList<T> heapArray = new ArrayList<T>(MAX_SIZE);

    private void insert(T data) {
        if (size == 0) {
            heapArray.set(0, data);
        } else {
            heapArray.set(size, data);
            heapify(size);
        }

        size++;
    }

    private void heapify(int size) {

    }

    private T findParent(int index) {
        return heapArray.get(index / 2);
    }

    private T findLeftChild(int index) {
        return heapArray.get(index * 2);
    }

    private T findRightChild(int index) {
        return heapArray.get(index * 2 + 1);
    }

}
