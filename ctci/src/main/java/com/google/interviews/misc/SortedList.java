package com.google.interviews.misc;

import java.util.ArrayList;
import java.util.List;

public class SortedList {

	private int findMinimum(List<Integer> list, int begin, int end) {
		int min = 0;
		
		System.out.println(begin + " " + end);
		
		if(end == begin) {
			min = list.get(0);
		} else if(end - begin == 1) {
			min = list.get(begin) < list.get(end) ? list.get(begin) : list.get(end);
		} else {
			int mid = begin + (end - begin)/2;
			System.out.println(begin + " " + mid + " " + end);
			if(list.get(mid) < list.get(end)) {
				min = findMinimum(list, begin, mid);
			} else {
				min = findMinimum(list, mid, end);
			}
		}
		
		return min;
	}
	
	
	public static void main(String args[]) {
		SortedList sl = new SortedList();
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		for(int i = -2; i < 89; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		System.out.println(sl.findMinimum(list, 0, list.size() - 1));
		
	}

}
