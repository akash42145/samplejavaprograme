package com.sample.stream;

import java.util.stream.IntStream;

public class StreamIterate {

	public static void main(String[] args) {
		IntStream.iterate(1, f -> f +2).limit(6).peek(System.out::println).sum();
	}

}
