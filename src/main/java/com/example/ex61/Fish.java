package com.example.ex61;

public class Fish extends Animal implements Pet {
	
	private String name;

	protected Fish(String name) {
		super(0);
		this.name = name;
		
	}

	@Override
	public void eat() {
		System.out.println("The fish eats plancton");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void play() {
		System.out.println(name +" plays with the boat");
	}

	@Override
	public void walk(){
		System.out.println("Fish can not walk!");
	}

	
}
