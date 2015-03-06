package com.google.interview.strings;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
	
	public static Set<String> calculatePermutations(String s) {
		Set<String> permutations = new HashSet<String>();
		
		
		if(s.length() == 1) {
			permutations.add(s);
			return permutations;
		}
		
		permutations = calculatePermutations(s.substring(1));
		
		return combineAll(permutations, s.charAt(0));
	}

	private static Set<String> combineAll(Set<String> permutations, char character) {
		Set<String> stringPermutations = new HashSet<String>();
		
		for(String s : permutations) {
			stringPermutations.addAll(combine(s, character));
		}
		
		return stringPermutations;
	}

	private static Set<String> combine(String s, char c) {
		Set<String> permutations = new HashSet<String>();
		
		
		for(int i = 0; i <= s.length(); i++) {
			permutations.add(new StringBuilder(s).insert(i, c).toString());
		}
		
		return permutations;
	}
	
	
	public static void main(String args[]) {
		System.out.println(calculatePermutations("hat"));
	}

}
