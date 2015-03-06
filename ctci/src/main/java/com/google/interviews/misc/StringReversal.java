package com.google.interviews.misc;

public class StringReversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s= "AdityAS";
		
		char[] array = s.toCharArray();
		for(int i = 0; i <= array.length/2; i++) {
			swap(array, i, array.length - 1 - i);
		}
		
		System.out.println(new String(array));

	}

	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	

}
