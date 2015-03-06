package com.effective.java.examples;

public class OperationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double args1 = 12.0;
		double args2 = 2.0;
		
		for(Operation o : Operation.values()) {
			System.out.printf("%f %s %f = %f%n", args1,o, args2, o.apply(args1, args2));
		}

	}

}
