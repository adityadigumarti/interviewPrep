package com.google.interview.arrays;

//activityReportanager

public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9 };
        System.out.println(findNumOccurances(array, 3));
    }

    public static int findNumOccurances(int arr[], int num) {
        int indexLeftMostElement = binarySearchNumOccurances(arr, num, true);

        if (indexLeftMostElement == -1) {
            return 0;
        }

        int indexRightMostElement = binarySearchNumOccurances(arr, num, false);

        return indexRightMostElement - indexLeftMostElement + 1;

    }

    public static int binarySearchNumOccurances(int arr[], int num, boolean searchLeft) {
        int low = 0, high = arr.length - 1, result = -1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == num) {
                result = mid;
                if (searchLeft) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (num < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static boolean binarySearch(int[] array, int num) {
        int start = 0;
        int end = array.length - 1;

        int mid;

        while (start <= end) {
            mid = calculateMid(start, end);

            if (array[mid] == num) {
                return true;
            } else {
                if (array[mid] > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return false;
    }

    private static int calculateMid(int start, int end) {
        return start + (end - start) / 2;
    }

}
