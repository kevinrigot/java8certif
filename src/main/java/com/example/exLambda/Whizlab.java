package com.example.exLambda;

import java.util.function.Function;

public class Whizlab {
	public static void main(String[] args) {
		Function<Integer, String> fun = s -> s.toString();
		//Compose expects a string, fun return a String
		Function<String, String> compose = fun.compose((String s) -> Integer.parseInt(s));
		Function<String, String> compose2 = compose.andThen((String s) -> s + "2");
		
		
	}

}