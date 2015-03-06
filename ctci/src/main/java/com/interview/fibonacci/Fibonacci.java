package com.interview.fibonacci;

public class Fibonacci {

	public Long fibonacci(int number) {
		if(number == 1 || number == 2) {
			return 1l;
		} else {
			return fibonacci(number - 1) + fibonacci(number - 2);
		}
	}
	
	public Long fibonacciLoop(int number) {
		long prev = 0;
		long current = 1;
		long fib = 1;
		
		for(int i = 2; i <= number; i++) {
			fib = prev + current;
			prev = current;
			current = fib;
		}
		
		return fib;
	}
	
	
	public long fibonacciTail(int number) {
		return fibonacciTail(number, 0, 1);
	}
	
	public long fibonacciTail(long number, long prev, long current) {
		if(number < 1) return current;
		
		return fibonacciTail(number - 1, current, current + prev);
	}
	/**
	 * 1,1,2,3,5,8 etc
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	

}









