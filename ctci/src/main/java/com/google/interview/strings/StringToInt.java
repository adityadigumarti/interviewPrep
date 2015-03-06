package com.google.interview.strings;

public class StringToInt {
	
	public static int convertToInt(String s) {
		String number = s.trim();
		
		if(number.matches("-?[0-9]*")) {
			System.out.println(number + "Matchesw");
		}
		
		return 0;
	}
	
	public static void main(String args[]) {
		convertToInt("0123456");
		convertToInt("-123456");
		convertToInt("-12sd3456");
	}

}
