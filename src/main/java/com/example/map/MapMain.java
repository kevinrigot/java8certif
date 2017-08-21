package com.example.map;

import java.util.Map;
import java.util.TreeMap;

public class MapMain {
	public static void main(String args[]) {
		//Map<Integer, Integer> tmap = new TreeMap<>(); --> Fail at line submap
		TreeMap<Integer, Integer> tmap = new TreeMap<>();
		tmap.put(9, 1);
		tmap.put(7, 3);
		tmap.put(8, 2);
		tmap.put(6, 4);
		System.out.println(tmap.subMap(6, true, 9, false).values());
	}
}