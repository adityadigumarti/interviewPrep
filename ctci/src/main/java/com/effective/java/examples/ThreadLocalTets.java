package com.effective.java.examples;

public class ThreadLocalTets {
	
	public static void main(String args[]) {
		
		for(int i = 0; i < 10; i++)
			new MyThread().start();
		
		
	}

}
