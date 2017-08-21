package com.example.enumtest;

public class TestEnumMain {

	public static void main(String[] args) {
		System.out.println(Month.APRIL.ordinal());

		for (Month m : Month.values()) {
			System.out.println(m);
		}
	}

}
