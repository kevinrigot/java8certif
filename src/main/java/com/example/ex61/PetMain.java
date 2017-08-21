package com.example.ex61;

public class PetMain {

	public static void main(String[] args) {
		Animal a;
		Spider s = new Spider();
		s.eat();
		s.walk();
		a = new Spider();
		a.eat();
		a.walk();
		
		Fish f = new Fish("molly");
		f.eat();
		f.play();
		f.walk();
		
		Cat c = new Cat("Corsaire");
		c.walk();
		c.play();
		c.eat();
		
		c.playWithAnimal(f);
		f.playWithAnimal(c);
		
		c.playWithAnimal(s);
		f.playWithAnimal(a);
	}

}
