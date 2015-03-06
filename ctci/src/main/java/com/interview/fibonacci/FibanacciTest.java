package com.interview.fibonacci;

public class FibanacciTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		
		for(int i = 1; i <= 10; i++)
		System.out.println(fib.fibonacciTail(i));
		

	}

}
