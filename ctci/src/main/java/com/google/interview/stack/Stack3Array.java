package com.google.interview.stack;

public class Stack3Array {
	
	private static final int NUM_STACKS = 3;
	private static final int DEFAULT_SIZE_PER_STACK = 3; 
	private int[] array = null;
	
	private int[] headStack = new int[NUM_STACKS];
	private int[] countStack = new int[NUM_STACKS];
	private int sizeStack[]  = new int[NUM_STACKS];
	private int totalElements = 0;
	
	
	public Stack3Array() {
		this(DEFAULT_SIZE_PER_STACK);
	}
	
	public Stack3Array(int size) {
		array = new int[size * NUM_STACKS];
		for(int i = 0; i < NUM_STACKS; i++) {
			headStack[i] = i* NUM_STACKS;
			countStack[i] = 0;
			sizeStack[i] = size;
		}
	}
	
	public void push(int data, int stackNum) {
		if(stackNum > NUM_STACKS - 1) {
			throw new IllegalArgumentException("Invalid Stack Number " + stackNum);
		}
		
		if(totalElements == array.length) {
			throw new StackFullException();
		}
		
		if(isSpaceAvailable(stackNum)) {
			array[headStack[stackNum] + countStack[stackNum]] = data;
		}else {
			moveHead(getNextStack(stackNum));
			shiftElements(stackNum);
		}
		
		countStack[stackNum] = countStack[stackNum] + 1;
		totalElements++;
	}
	
	public int pop(int stackNum) {
		if(countStack[stackNum] == 0) {
			throw new StackEmptyException();
		}
		
		countStack[stackNum] = countStack[stackNum] - 1;
		totalElements--;
		
		return array[headStack[stackNum] + countStack[stackNum]];
	}

	private void moveHead(int stackNum) {
		if(isSpaceAvailable(stackNum)) {
			shiftElements(stackNum);
		}else {
			moveHead(getNextStack(stackNum));
			shiftElements(stackNum);
		}
	}

	private void shiftElements(int stackNum) {
		for(int i = headStack[stackNum] + countStack[stackNum]; i > headStack[stackNum]  ; i--) {
			array[i] = array[i - 1];
		}
		
		headStack[stackNum] = headStack[stackNum] + 1;
		sizeStack[stackNum] = sizeStack[stackNum] - 1;
	}

	private int getNextStack(int stackNum) {
		return stackNum + 1 < NUM_STACKS ? stackNum + 1 : stackNum + 1 - NUM_STACKS;
	}
	
	boolean isSpaceAvailable(int stackNum) {
		return countStack[stackNum] < sizeStack[stackNum];
	}
	
	
	public String toString() {
		String s = "";
		
		for(int i = 0; i < NUM_STACKS; i++) {
			s += headStack[i] + "-" + countStack[i] + "-" + sizeStack[i];
			s += " ";
		}
		
		return s;
	}
	public void print() {
		System.out.println(toString());
	}

}
