package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ArrayMain {

	public static void main(String[] args) {
		int[] ints = {1,2, 3};
		//Works with indexes of int[]
		Arrays.parallelSetAll(ints, x->x+10);
		System.out.println(ints[0]+","+ints[1]+","+ints[2]);
		
		String[] strings = {"1","2","3"};
		Arrays.parallelSetAll(strings, x->Integer.toString(x)+strings[x]);
		System.out.println(strings[0]+","+strings[1]+","+strings[2]);
		
		
		List list = new ArrayList();
		list.add("one");
		list.add("two");
//		Predicate bad = s -> s.startsWith("one");
		Predicate<String> p = s -> s.startsWith("one");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 6, 6);
		int sum = numbers.stream().map( i -> i*i).distinct().mapToInt((x) -> x).sum();
		System.out.println(sum);
		
		List<String> exams = new ArrayList<>();
		exams.add("1ZO-BOB");
		exams.add("1Z1-809");
		exams.add("1Zi—810");
		Predicate<String> p2 = s -> s.startsWith("1Z1");
		System.out.println(exams.stream().filter(s->s.startsWith("1Z1")).anyMatch(p));
	}

}
