package com.example.sortlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DavidIsAMoron {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(2);
		list.add(3);
		list.add(6);
		list.add(11);
		list.add(7);
		list.add(8);
		list.add(1);
		list.add(5);
		list.add(10);
		list.add(4);
		System.out.println(list);
		System.out.println("ORDER");
		Collections.sort(list);
		System.out.println(list);
	}
}
