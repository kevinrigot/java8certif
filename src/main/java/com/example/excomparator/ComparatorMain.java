package com.example.excomparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

	public static void main(String[] args) {
		Comparator<Integer> compNullsFirst = Comparator.nullsFirst(Integer::compare);
		Comparator<Integer> compNullsLast = Comparator.nullsLast(Integer::compare);

		System.out.println("Compare Integer 1 & 3: " + Integer.compare(1, 3));
		System.out.println("Compare Integer null & 3 with nullsFirst: " + compNullsFirst.compare(null, 3));
		System.out.println("Compare Integer 3 & null with nullsFirst: " + compNullsFirst.compare(3, null));
		System.out.println("Compare Integer null & 3 with nullsLast: " + compNullsLast.compare(null, 3));

		List<Integer> list = Arrays.asList(1, 9, 3, 8, 5, 6, null, 3, 4);
		System.out.println("Unsorted list:" + list);
		System.out.println("Sort list using Integer.compare");
		try {
			list.stream().sorted(Integer::compare).forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("NullPointerException with the default compare");
		}
		System.out.println("Sort list using nullsFirst");
		list.stream().sorted(compNullsFirst).forEach(System.out::println);
		System.out.println("Sort list using nullsLast");
		list.stream().sorted(compNullsLast).forEach(System.out::println);
	}

}
