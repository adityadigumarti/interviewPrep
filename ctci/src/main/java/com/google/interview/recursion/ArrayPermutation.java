package com.google.interview.recursion;

public class ArrayPermutation {

    void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println("");
    }

    void permute(int[] a, int k) {
        if (k == a.length)
            printArray(a);
        else
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
                permute(a, k + 1);
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
    }

    public static void main(String[] args) {
        ArrayPermutation p = new ArrayPermutation();
        int a[] = {1, 2, 3 };
        p.permute(a, 0);
    }

}
