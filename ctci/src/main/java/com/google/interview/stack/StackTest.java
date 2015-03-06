package com.google.interview.stack;

public class StackTest {

	/**
	 * @param args
	 * @throws StackEmptyException 
	 */
	public static void main(String[] args) {
		Stack2<Integer> intStack = new Stack2<Integer>();
		System.out.println(intStack.isEmpty());
		intStack.push(101);
		
		System.out.println(intStack.peek());
		
		System.out.println(intStack.isEmpty());
		intStack.push(102);
		System.out.println(intStack.peek());
		System.out.println(intStack.isEmpty());
		intStack.push(103);
		System.out.println(intStack.peek());
		System.out.println(intStack.isEmpty());
		intStack.push(104);
		System.out.println(intStack.peek());
		System.out.println(intStack.isEmpty());
		intStack.push(105);
		System.out.println(intStack.peek());
		System.out.println(intStack.isEmpty());
		
		System.out.println(intStack.pop());
		System.out.println(intStack.peek());
		System.out.println(intStack.pop());
		System.out.println(intStack.peek());
		
		intStack.push(106);
		intStack.prettyPint();
		System.out.println(intStack.peek());
		System.out.println(intStack.pop());
		System.out.println(intStack.isEmpty());
		
		intStack = new Stack2<Integer>();
		System.out.println(intStack.isEmpty());
		
		for(int i = 100; i < 120; i++) {
			intStack.push(i);
			System.out.println(intStack.size());
		}
		
		intStack.prettyPint();
		
		System.out.println(intStack.isEmpty());
		
		System.out.println(intStack.pop());
		
		intStack.prettyPint();

	}

}
