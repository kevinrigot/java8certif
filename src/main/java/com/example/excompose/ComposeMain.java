package com.example.excompose;

import java.util.function.LongUnaryOperator;

public class ComposeMain {

	public static void main(String[] args) {
		LongUnaryOperator multiply = l -> l*2;
		LongUnaryOperator addition = l -> l+1;
		
		//First compose, then apply
		//3+1  4*2
		System.out.println(multiply.compose(addition).applyAsLong(3));
		//3*2  6+1
		System.out.println(addition.compose(multiply).applyAsLong(3));
		
		System.out.println(addition.andThen(multiply).applyAsLong(3));
	}

}
