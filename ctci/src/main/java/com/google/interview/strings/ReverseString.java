package com.google.interview.strings;

public class ReverseString {
	
	public static String reverseString(String s) {
		StringBuilder sb = new StringBuilder(s);
		char ch = ' ';
		int length = s.length();
		
		for(int i = 0; i < length/2; i++) {
			ch = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(length - i - 1));
			sb.setCharAt(length - i - 1, ch);
		}
		
		return sb.toString();
	}
	
	
	public static void main(String args[]) {
		System.out.println(reverseString("Digumarti"));
		System.out.println(reverseString("Aditya"));
		System.out.println(reverseString("Digumarti Aditya Kiran")); 
	}

}
