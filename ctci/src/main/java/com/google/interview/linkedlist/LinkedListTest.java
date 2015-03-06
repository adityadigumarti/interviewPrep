package com.google.interview.linkedlist;

import com.google.interview.stack.Node;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(1);
		ll.insert(2);
		
		System.out.println(ll);
		
		System.out.println(ll.isPalindrome());
		
		System.out.println(ll);
		
	}

}
