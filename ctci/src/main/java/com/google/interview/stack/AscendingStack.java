package com.google.interview.stack;

public class AscendingStack<T extends Comparable> {

	private Stack2<T> ascendingStack = new Stack2<T>();
	private Stack2<T> tempStack = new Stack2<T>();
	
	public void push(T data) {
		if(ascendingStack.isEmpty()) {
			ascendingStack.push(data);
		} else {
			while(!ascendingStack.isEmpty() && ascendingStack.peek().compareTo(data) > 0) {
				tempStack.push(ascendingStack.pop());
			}
		
			ascendingStack.push(data);
			
			while(!tempStack.isEmpty()) {
				ascendingStack.push(tempStack.pop());
			}
	  }
		
		print();
	}
	
	public void print() {
		ascendingStack.prettyPint();
		//tempStack.prettyPint();
	}

}
