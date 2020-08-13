package com.sample.spliterator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Print day of date of birth from birth.
 *
 */
public class PrintDobDayFromBirth {

	public static void main(String[] args) {

		
		List<String> ls = StreamSupport.stream(new YearSpliterator(LocalDate.of(2019, 11, 14)), false)
				.takeWhile(date -> date.getYear() >= 1985)
				.map(m -> /*m.getDayOfWeek()*/m.toString()).collect(Collectors.toList());
				//.forEach(System.out::println);
		
		System.out.println(ls);
	}

}
