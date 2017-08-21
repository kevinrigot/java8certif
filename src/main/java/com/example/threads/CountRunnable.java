package com.example.threads;

public class CountRunnable implements Runnable {
	private int count;
	private String threadName;
	public CountRunnable(int count, String threadName) {
		super();
		this.count = count;
		this.threadName = threadName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	@Override
	public void run() {
		while(count>0){
			System.out.println("Thread "+threadName+" count#"+(count--));
		}
	}
	
	


}
