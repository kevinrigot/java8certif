package com.example.test;

import java.util.function.Function;

public class TestIdentity {

	public static void main(String[] args) {
		Function<Double, Double> identityDouble = Function.identity();
		System.out.println(identityDouble.apply(10.0));

		/*Compil fail
		Function<Double, Integer> identityIntDouble = Function.identity();
		System.out.println(identityDouble.apply(10.0));*/
	}

}
