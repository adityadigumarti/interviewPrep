package com.effective.java.examples;

public class MyThread extends Thread {
	
	@Override
	public void run() {
		System.out.println(new MyThreadLocal().getId() + "********" +  this.getId() + "*********");
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(new MyThreadLocal().getId() + "********" +  this.getId() + "*********");
		
		
		new MyThreadLocal().remove();
		
	}

}
