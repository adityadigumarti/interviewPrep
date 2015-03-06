package com.google.interview.strings;

import java.util.Stack;

public class ReverseWords {
	
	public static void main(String[] args) {
		System.out.println(reverseWords(""));
		System.out.println(reverseWords("       "));
		System.out.println(reverseWords("    .        "));
		System.out.println(reverseWords("A"));
		System.out.println(reverseWords("Kiran"));
		System.out.println(reverseWords("Aditya Kiran"));
		System.out.println(reverseWords("       Aditya     Kiran    Digumarti              "));
	}
	
	public static String reverseWords(String s) {
		Stack<String> stack = new Stack<String>();
		int indexOfSpace = 0;
		int numSpaces = 0;
		StringBuilder sb = null;
		
		
		int i = 0;
		
		while(i < s.length()) {
			sb = new StringBuilder();
			
			while(i < s.length() && s.charAt(i) == ' ') {
				sb.append(' ');
				i++;
			}
			
			stack.push(sb.toString());
			
			sb = new StringBuilder();
			while(i < s.length() && s.charAt(i) != ' ') {
				sb.append(s.charAt(i));
				i++;
			}
			
			stack.push(sb.toString());
			
			
		}
		
		sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	public static String reverseWordsInPlace(String s) {
		String reversedString = ReverseString.reverseString(s);
		
		StringBuilder sb = new StringBuilder(reversedString);
		
		int i = 0;
		int wordBeginIndex = 0;
		int wordEndIndex = 0;
		while(i < sb.length()) {
			while(sb.charAt(i) == ' ') {
				i++;
			}
			
			wordBeginIndex = i;
			
			while(sb.charAt(i) != ' ') {
				i++;
			}
			
			wordEndIndex = i;
			
			reverseInPlace(sb, wordBeginIndex, wordEndIndex);
		}
		
		return sb.toString();
	}

	private static void reverseInPlace(StringBuilder sb, int wordBeginIndex,
			int wordEndIndex) {
		int mid = wordBeginIndex + (wordEndIndex - wordBeginIndex)/2;
		char ch;
		
		for(int i = 0; i < mid - wordBeginIndex; i++) {
			ch = sb.charAt(wordBeginIndex + i);
			sb.setCharAt(wordBeginIndex + i, sb.charAt(wordEndIndex - i));
			sb.setCharAt(wordEndIndex - i, sb.charAt(wordBeginIndex + i));
		}
	}
	

}
