package java8.date.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Java8Date {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate); //today

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println(tomorrow);

		boolean isBefore = LocalDate.parse("2018-04-29").isBefore(LocalDate.parse("2018-04-30"));
		System.out.println(isBefore); //true

		boolean notAfter = LocalDate.parse("2018-04-29").isAfter(LocalDate.parse("2018-04-30"));
		System.out.println(notAfter); //false
		
		LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println(previousMonthSameDay);

	}

}
