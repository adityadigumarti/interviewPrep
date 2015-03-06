package com.google.interviews.misc;

public class MaxRotatedArray {
	
	public static void main(String args[]) {
		int array[] = {8,9,10,11,12,13,1,2,3,4,5,6,7};
		System.out.println(getMax(array));
	}
	
	public static int getMax(int[] array) {
		if(array.length == 0) {
			return -1;
		}
		
		int low = 0;
		int high = array.length - 1;
		int mid = -1;
		
		while(array[low] > array[high]) {
			mid = low + (high - low)/2;
			
			if(array[low] < array[mid]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		
		return array[high];
	}
	
	
	public static int findFibonacci(int n) {
		int previous = 1;
		int current = 1;
		int next = -1;
		
		for(int i = 3; i <= n; i++) {
			next = previous + current;
			previous = current;
			current = next;
		}
		
		return next;
	}

}
