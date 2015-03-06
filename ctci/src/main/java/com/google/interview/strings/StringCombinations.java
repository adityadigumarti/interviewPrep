package com.google.interview.strings;

import java.util.ArrayList;
import java.util.List;

public class StringCombinations {
	
	public static List<String> calculateCombinations(String s) {
		List<String> combinations = new ArrayList<String>();
		combinations.add(s);
		StringBuffer sb = null;
		
		if(s.length() == 1) {
			return combinations;
		}
		
		for(int i = 0; i < s.length(); i++) {
			sb = new StringBuffer(s);
			combinations.addAll(calculateCombinations(sb.deleteCharAt(i).toString()));
		}
		
		return combinations;
	}
	
	public static void calculateCombinationsImproved(String s, List<String> list) {
		
		if(s.length() == 1) {
			list.add(s);
			return;
		}
		
		String pre = s.substring(0,1);
		String post = s.substring(1, s.length());
		
		calculateCombinationsImproved(post, list);
		combine(pre, list);
		list.add(pre);
		
		System.out.println(list);
		
	}

	
	
	
	private static void combine(String pre,
			List<String> subList) {
		
		List<String> list = new ArrayList<String>();
		
		for(String s : subList)
			list.add(pre + s);
		
		System.out.println(list);
		subList.addAll(list);
	}

	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		calculateCombinationsImproved("xyz", list);
		System.out.println(list);
	}

}
