package com.example.ex61;

public interface Pet {

	public String getName();

	public void setName(String name);

	public void play();

	public default void playWithAnimal(Animal a) {
		if (a instanceof Pet) {
			System.out.println(getName() + " plays with");
			((Pet) a).play();
		} else {
			System.out.println("Danger wild animal");
		}
	}

}
