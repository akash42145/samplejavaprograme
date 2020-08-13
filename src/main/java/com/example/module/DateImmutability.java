package com.example.module;

import java.time.LocalDate;

public class DateImmutability {

	public static void main(String[] args) {
		final LocalDate date = LocalDate.now();
		
		LocalDate temp = date;
		
		temp = temp.plusDays(1);
		
		System.out.println(date);
		
		System.out.println(temp);
		
	}

}
