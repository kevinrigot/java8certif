package com.example.exinheritance;

public interface Flyer {
	default String identifyMyself(){
		return "Im able to fly";
	}
}
