package com.effective.java.examples;

public enum Operation {
	
	PLUS("+") { public double apply(double args1, double args2) {return args1 + args2;} },
	MINUS("-") { public double apply(double args1, double args2) {return args1 - args2;} },
	MULTIPLY("*") { public double apply(double args1, double args2) {return args1 * args2;} },
	DIVIDE("/") { public double apply(double args1, double args2) {return args1 / args2;} };
	
	private String symbol;
	
	private Operation(String symbol) {
		this.symbol = symbol;
	}
	
	public  abstract double apply(double args1, double args2); 
	
	public String toString() {return symbol;}

}
