package com.example.ex61;

public class Cat extends Animal implements Pet {

	private String name;

	public Cat(String name) {
		super(4);
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println("The cat eats a mouse");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public void play() {
		System.out.println(name+" plays with the mouse");
	}

}
