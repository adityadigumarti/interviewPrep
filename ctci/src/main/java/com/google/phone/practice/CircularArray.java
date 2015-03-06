package com.google.phone.practice;

public class CircularArray {

    public int findLargest(int[] array) {
        return findLargest(array, 0, array.length - 1);
    }

    public int findLargest(int[] array, int start, int end) {
        if (start == end) {
            return array[start];
        }

        if (end - start == 1) {
            return array[start] > array[end] ? array[start] : array[end];
        }

        int mid = start + (end - start) / 2;

        if (array[mid] >= array[start]) {
            return findLargest(array, mid, end);
        } else {
            return findLargest(array, start, mid);
        }

    }

    // public int binarySearch(int[] array, int key, int start, int end) {
    // if (end < start) {
    // return -1;
    // }
    //
    // int mid = start + (end - start) / 2;
    //
    // if (array[mid] == key) {
    // return mid;
    // }
    //
    // // Key > Mid or Key < Mid
    //
    // if (key < array[mid]) {
    // if (array[start] <= array[mid] && key > array[start]) {
    // end = mid - 1;
    // } else {
    // start = mid + 1;
    // }
    // } else { // key > mid
    // if (array[end] >= array[mid] && key < array[end]) {
    // start = mid + 1;
    // } else {
    // end = mid - 1;
    // }
    // }
    //
    // return binarySearch(array, key, start, end);
    // }

    public int binarySearch(int[] array, int key, int start, int end) {
        if (end < start) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (array[mid] == key) {
            return mid;
        }

        // Key > Mid or Key < Mid

        if (key < array[mid]) {
            if (array[start] <= array[mid] && array[start] > key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } else { // key > mid
            if (array[end] >= array[mid] && key > array[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;

            }
        }

        return binarySearch(array, key, start, end);
    }

    private static int circularBinSearch(int[] A, int key, int low, int high) {
        if (low > high) {
            return -1; // not found
        }

        int mid = (low + high) / 2;

        if (A[mid] == key) {
            return mid;
        } else if (key < A[mid]) {
            return ((A[low] <= A[mid]) && (A[low] > key)) ? circularBinSearch(A, key, mid + 1, high)
                    : circularBinSearch(A, key, low, mid - 1);
        } else // key > A[mid]
        {
            return ((A[mid] <= A[high]) && (key > A[high])) ? circularBinSearch(A, key, low, mid - 1)
                    : circularBinSearch(A, key, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {23, 27, 29, 31, 37, 43, 49, 56, 64, 78, 91, 99, 1, 4, 11, 14, 15, 17, 19 };

        for (int i = 0; i < array.length; i++)
            System.out.println(new CircularArray().binarySearch(array, array[i], 0, array.length - 1));

    }

}
