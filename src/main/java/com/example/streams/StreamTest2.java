package com.example.streams;

import java.util.stream.IntStream;

public class StreamTest2 {

	public static void main(String[] args) {
		IntStream stream = IntStream.of(1,2,3,4,5);
		System.out.println(stream.max() + " " +stream.min()); // Exception --> stream closed
	}

}
