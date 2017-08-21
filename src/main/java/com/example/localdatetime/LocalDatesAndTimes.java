package com.example.localdatetime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDatesAndTimes {

	public static void main(String[] args) {
		LocalDate kevBday = LocalDate.now().withYear(1984).withMonth(10).withDayOfMonth(12);
		System.out.println(kevBday);
		System.out.println("Kev is "+ChronoUnit.YEARS.between(kevBday, LocalDate.now()));
		System.out.println("Kev is "+kevBday.until(LocalDate.now(), ChronoUnit.YEARS));
		
		System.out.println("Kev lived in days "+ChronoUnit.DAYS.between(kevBday, LocalDate.now()));
		System.out.println("Kev is born in a leap year "+kevBday.isLeapYear());
		System.out.println("Number of days in this year "+kevBday.lengthOfYear());
		System.out.println("It was "+kevBday.getDayOfWeek());
		
		LocalDate kev18Bday = kevBday.plusYears(18);
		System.out.println("Kev was 18 on "+kev18Bday);
		System.out.println("It was a "+kev18Bday.getDayOfWeek());
		
		
		LocalTime depart = LocalTime.of(13, 45);
		LocalTime arrival = LocalTime.of(19, 25);
		System.out.println("Departure: "+depart);
		System.out.println("Planned travel time in min "+depart.until(arrival, ChronoUnit.MINUTES));
		
		LocalDateTime leaveBoston = LocalDateTime.of(2017, Month.MARCH, 24, 21, 15);
		LocalDateTime arriveMiami = leaveBoston.plusHours(4).plusMinutes(15);
		System.out.println("Plane leave from Boston on "+leaveBoston+" and arrives at Miami on "+arriveMiami);
		
		System.out.println("next happy hour:" +LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
		System.out.println(LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
		System.out.println(LocalDate.now().plusMonths(2).with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
		System.out.println(LocalDate.now().plusMonths(3).with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
		System.out.println(LocalDate.now().plusMonths(4).with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
		
		System.out.println("next 2nd tuesday of the month:" +LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY)));
		System.out.println(LocalDate.now().plusMonths(1).with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY)));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("eeee d MMMM u");
		System.out.println("Formatted date: "+kevBday.format(formatter ));
		
		String dateToParse = "2015-04-04";
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Parse date: "+dateToParse);
		LocalDate parsed = LocalDate.parse(dateToParse, formatter);
		System.out.println("parsed+1m:" +parsed.plusMonths(1));
		System.out.println("Nb of years since: "+Period.between(parsed, LocalDate.now()).getYears());
		
		
//		Instant now = Instant.now();
//		now = now.truncatedTo(ChronoUnit.MONTHS); //Unit is too large to be used for truncation
//		System.out.println(now);
		
		LocalDate ld = LocalDate.of(2010, 1, 2);
		Period due = Period.ofDays(-2).plusMonths(1);
		ld= ld.plus(due);
		System.out.println(ld);
		
		//Always substract first the days
		ld = LocalDate.of(2010, 1, 2);
		due = Period.ofMonths(1).minusDays(2);
		ld= ld.plus(due);
		System.out.println(ld);
		
		LocalTime lt = LocalTime.of(2, 2,15);
		System.out.println(lt.getLong(ChronoField.valueOf("MINUTE_OF_DAY")));
	}

}
