package com.example.exLambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ReduceMain {

	public static void main(String[] args) {
		List<String> vals = Arrays.asList("a", "b", "c", "d", "e", "f", "g", 
				"a", "b", "c", "d", "e", "f", "g", 
				"a", "b", "c", "d", "e", "f", "g", 
				"a", "b", "c", "d", "e", "f", "g"); 
		String join = vals.parallelStream()
				.peek(System.out::println) //this shows how the elements are retrieved from the stream         
				.reduce("_", 
						(a, b)->{
							System.out.println("reducing "+a+" and "+b+" Thread: "+Thread.currentThread().getName());
							return a.concat(b);
						},
						(a, b)->{
							System.out.println("combining "+a+" and "+b+" Thread: "+Thread.currentThread().getName()); 
							return a.concat(b);
						}); 
		System.out.println(join);
		
		IntStream ints = IntStream.of(1,2,7, 32);
		OptionalInt out = ints.filter(in -> in%2==0).reduce(Integer::sum);
		System.out.println(out);
	}

}
