package com.effective.java.examples;

public class StringReversal {
	
	public String reverseString(String s) {
		if(s.length() == 1) {
			return s;
		}else {
			return reverseString(s.substring(1)) + s.substring(0, 1);
		}
	}

	
	public String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		char temp;
		
		for(int i = 0; i < sb.length()/2; i++) {
			temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(sb.length() - i - 1));
			sb.setCharAt(sb.length() - i - 1, temp);
		}
		
		return sb.toString();
	}
	
	
	public static void main(String args[]) {
		System.out.println(new StringReversal().reverseString("ADITYA"));
		System.out.println(new StringReversal().reverse("KIRANA"));
	}

}
