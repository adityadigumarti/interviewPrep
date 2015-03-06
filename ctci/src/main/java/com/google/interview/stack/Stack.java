package com.google.interview.stack;

import java.util.*;

public class Stack<T extends Comparable> {
	
	private static int MAX_SIZE = 20;
	private int index = -1;
	
	private List<T> list;
	
	public void Stack() {
		Stack(MAX_SIZE);
	}
	
	public void Stack(int maxSize) {
		list = new ArrayList<T>(MAX_SIZE);
	}
	
	public void push(T value) {
		if(list.size() == MAX_SIZE) {
			throw new StackFullException();
		}
		
		list.add(value);
		index++;
	}
	
	
	public T pop() {
		if(index == -1) {
			throw new StackEmptyException();
		}
		
		return list.remove(index--);
		
	}
	
	public int size() {
		return index + 1;
	}
	
	public T peek() {
		return list.get(index);
	}
	
	public boolean isEmpty() {
		return index == -1;
	}
	
	public String toString() {
		return list.toString();
	}
	
}