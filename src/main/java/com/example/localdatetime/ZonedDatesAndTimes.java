package com.example.localdatetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ZonedDatesAndTimes {
	public static void main(String[] args) {
		ZoneId bxl = ZoneId.of("Europe/Brussels");
		ZoneId kuala = ZoneId.of("Asia/Kuala_Lumpur");
		LocalDateTime departure = LocalDateTime.of(2017, Month.JUNE, 16, 10, 35);
		LocalDateTime arrival = LocalDateTime.of(2017, Month.JUNE, 17, 6, 50);
		ZonedDateTime departBxl = ZonedDateTime.of(departure, bxl);
		System.out.println("Flight depart "+departBxl);
		ZonedDateTime arrivalKL = ZonedDateTime.of(arrival, kuala);
		System.out.println("Time in Kuala Lumpur:" + departBxl.toOffsetDateTime().atZoneSameInstant(kuala));
		System.out.println("Flight arrive "+arrivalKL);
		System.out.println("Time in Bxl:" + arrivalKL.toOffsetDateTime().atZoneSameInstant(bxl));
		System.out.println("Flight duration "+departBxl.until(arrivalKL, ChronoUnit.HOURS));
		
		Instant now = Instant.now();
	}
}
