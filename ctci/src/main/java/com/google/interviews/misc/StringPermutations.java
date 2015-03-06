package com.google.interviews.misc;

import java.util.*;

public class StringPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		StringPermutations sp = new StringPermutations();
		
		System.out.println(sp.findPermutations("abcd"));
		

	}
	


	private Set<String> findPermutations(String string) {
		Set<String> list = new HashSet<String>();
		
		if(string.length() == 1) {
			list.add(string);
		} else {
			System.out.println("***" + string);
			list.addAll(combine(string.substring(0, 1), findPermutations(string.substring(1, string.length()))));
		}
		
		return list;
		
	}

	private Set<String> combine(String s,
			Set<String> findPermutations) {
		
		Set<String> set = new HashSet<String>();
		
		for(String fp : findPermutations) {
			set.addAll(combine(s, fp));
		}
		
		return set;
	}

	public Set<String> combine(String s, String sb) {
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i <= sb.length(); i++) {
			set.add(new StringBuilder(sb).insert(i, s).toString());
		}
		
		return set;
	}
	
	
	
	

}
