package com.sample.spliterator;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class YearSpliterator implements Spliterator<LocalDate> {

	LocalDate date;

	public YearSpliterator(LocalDate date) {
		this.date = date;
	}

	@Override
	public boolean tryAdvance(Consumer<? super LocalDate> action) {
		int i=0;
		System.out.println(" Inside try advance "+ ++i);
		//action.accept(date); // It will make two entry
		Objects.requireNonNull(action);
		action.accept(date);
		date = date.minusYears(1);

		return true;
	}

	@Override
	public Spliterator<LocalDate> trySplit() {

		return null;
	}

	@Override
	public long estimateSize() {

		return Long.MAX_VALUE;
	}

	@Override
	public int characteristics() {

		return ORDERED | DISTINCT;
	}

}
