package com.effective.java.examples;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadLocal {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	
	
	private static final ThreadLocal<Integer> id = new ThreadLocal<Integer>() {
		
		@Override
		protected Integer initialValue() {
	        return count.incrementAndGet();
	    }
		
		
		
	};
	
	public Integer getId() {
		return id.get();
	}
	
	
	public void remove() {
		id.remove();
	}
	
	
	

}
