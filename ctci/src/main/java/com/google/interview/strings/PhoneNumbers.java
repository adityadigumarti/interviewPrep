package com.google.interview.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumbers {
	
	private static Map<Character, List<Character>> phoneNumToText;
	
	static {
		populateMap();
	}
	
	
	public List<Character> getCharacter(int number) {
		return phoneNumToText.get(number);
	}


	private static void populateMap() {
		phoneNumToText = new HashMap<Character, List<Character>>();
		
		List<Character> one = new ArrayList<Character>();
		
		one.add('1');
		
		List<Character> two = new ArrayList<Character>();
		two.add('A');
		two.add('B');
		two.add('C');
		
		List<Character> three = new ArrayList<Character>();
		three.add('D');
		three.add('E');
		three.add('F');
		
		List<Character> four = new ArrayList<Character>();
		four.add('G');
		four.add('H');
		four.add('I');
		
		List<Character> five = new ArrayList<Character>();
		five.add('J');
		five.add('K');
		five.add('L');
		
		List<Character> six = new ArrayList<Character>();
		six.add('M');
		six.add('N');
		six.add('O');
		
		List<Character> seven = new ArrayList<Character>();
		seven.add('P');
		seven.add('Q');
		seven.add('R');
		seven.add('S');
		
		List<Character> eight = new ArrayList<Character>();
		eight.add('T');
		eight.add('U');
		eight.add('V');
		
		List<Character> nine = new ArrayList<Character>();
		nine.add('W');
		nine.add('X');
		nine.add('Y');
		nine.add('Z');
		
		List<Character> zero = new ArrayList<Character>();
		zero.add('0');
		
		phoneNumToText.put('1', one);
		phoneNumToText.put('2', two);
		phoneNumToText.put('3', three);
		phoneNumToText.put('4', four);
		phoneNumToText.put('5', five);
		phoneNumToText.put('6', six);
		phoneNumToText.put('7', seven);
		phoneNumToText.put('8', eight);
		phoneNumToText.put('9', nine);
		phoneNumToText.put('0', zero);
		
	}
	
	public List<String> getAllTextCombinations(String phoneNumber) {
		List<StringBuilder> sbList = new ArrayList<StringBuilder>();
		sbList.add(new StringBuilder(""));
		List<StringBuilder> newList =  null;
		
		char phoneDigit;
		for(int i = 0; i < phoneNumber.length(); i++) {
			newList = new ArrayList<StringBuilder>();
			phoneDigit = phoneNumber.charAt(i);
			
			for(StringBuilder sb : sbList) {
				for(char ch : phoneNumToText.get(phoneDigit)) {
					newList.add(new StringBuilder(sb).append(ch));
				}
			}
			
			sbList = newList;
		}
		
		List<String> list = new ArrayList<String>();
		for(StringBuilder sb : sbList) {
			System.out.println(sb.toString());
			list.add(sb.toString());	
		}
		
		return list;
		
	}
	
	public List<String> getAllCombinationsRecursive(String phoneNumber) {
		List<String> numbers = null;
		
		if(phoneNumber.length() == 1) {
			numbers = new ArrayList<String>();
			for(char ch : phoneNumToText.get(phoneNumber.charAt(0)))
				numbers.add(String.valueOf(ch));
			
			return numbers;
		}
		
		numbers = getAllCombinationsRecursive(phoneNumber.substring(1));
		
		return combine(numbers, phoneNumToText.get(phoneNumber.charAt(0)));
		
	}
	
	private List<String> combine(List<String> numbers, List<Character> list) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String args[]) {
		PhoneNumbers pn = new PhoneNumbers();
		
		System.out.println(pn.getAllTextCombinations("8662655").size());
		System.out.println(Math.pow(3.0, 7.0));
	}

}
