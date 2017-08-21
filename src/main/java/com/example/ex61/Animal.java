package com.example.ex61;

public abstract class Animal /* implements Walk, Run*/{
	protected int legs;
	
	protected Animal(int legs){
		this.legs = legs;
	}
	
	public void walk(){
		System.out.println("This animal walks on "+legs+" legs");
	}
	
	public abstract void eat();

}
