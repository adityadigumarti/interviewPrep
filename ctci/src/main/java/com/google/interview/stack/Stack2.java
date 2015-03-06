package com.google.interview.stack;

public class Stack2<T> {

	private static final int DEFAULT_MAX_DEPTH = 100; 
	
	private Node<T> top;
	private int depth = 0;
	private int maxDepth;
	
	public Stack2() {
		this(DEFAULT_MAX_DEPTH);
	}
	
	public Stack2(int maxDepth) {
		this.maxDepth = maxDepth; 
	}
	
	public boolean isEmpty() {
		return depth == 0;
	}
	
	public boolean isFull() {
		return depth == maxDepth;
	}
	
	public void push(T data) {
		if(depth == maxDepth) {
			throw new StackFullException();
		}
		
		Node<T> node = new Node<T>(data);
		
		if(top == null) {
			top = node;
		}else {
			node.setNext(top);
			top = node;
		}
		
		depth++;
		
	}
	
	public T pop() {
		if(depth == 0) {
			throw new StackEmptyException();
		}
		
		T poppedData = top.getData();
		top = top.getNext();
		
		depth--;
		
		return poppedData;
	}
	
	public T peek() {
		if(depth == 0) {
			throw new StackEmptyException();
		};
		
		return top.getData();
	}
	
	public void prettyPint() {
		Node n = top;
		while(n != null) {
			System.out.print(n.getData() + ", ");
			n = n.getNext();
		}
		
		System.out.println();
	}
	
	public int size() {
		return depth;
	}

}
