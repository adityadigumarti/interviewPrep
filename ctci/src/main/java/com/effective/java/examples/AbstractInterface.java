package com.effective.java.examples;

import java.util.AbstractList;
import java.util.*;

public class AbstractInterface {
	
	static List<Integer> intArrayAsList(final int[] a) {
		if (a == null)
		throw new NullPointerException();
		return new ArrayList<Integer>() {
		public Integer get(int i) {
		return a[i]; // Autoboxing (Item 5)
		}
		@Override public Integer set(int i, Integer val) {
		int oldVal = a[i];
		a[i] = val; // Auto-unboxing
		return oldVal; // Autoboxing
		}
		public int size() {
		return a.length;
		}
		};
		}
	

}
