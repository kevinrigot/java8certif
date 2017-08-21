package com.example.localdatetime;

import java.time.Period;

public class PeriodMain {
	public static void main(String[] args) {
		System.out.println(Period.ZERO.getUnits());
		System.out.println(Period.ofYears(2015).getUnits());
		
	}
}
