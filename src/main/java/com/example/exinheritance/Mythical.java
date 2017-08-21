package com.example.exinheritance;

public interface Mythical {
	default String identifyMyself(){
		return "Im a mythial creature";
	}
}
