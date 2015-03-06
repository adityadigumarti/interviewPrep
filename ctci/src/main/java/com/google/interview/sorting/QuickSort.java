package com.google.interview.sorting;

public class QuickSort {

    public static void main(String args[]) {
        int[] array = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
        new QuickSort().quickSort(array);

        for (int i : array)
            System.out.println(i);
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int i, int j) {
        int low = i;
        int high = j;

        if (j - i == 1 || j == i) {
            return;
        }

        int pivot = i + (j - i) / 2;
        int pivotValue = array[pivot];

        while (low <= high) {
            while (array[low] < pivotValue) {
                low++;
            }

            while (array[high] > pivotValue) {
                high--;
            }

            if (low <= high) {
                interchange(array, low, high);
                low++;
                high--;
            }
        }

        if (i < high) {
            quickSort(array, i, high);
        }

        if (low < j) {
            quickSort(array, low, j);
        }

    }

    private void interchange(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
