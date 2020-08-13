package com.sample.overloading;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class OverloadingClient {

	public static void main(String[] args) {
		
		OverloadingClient client  = new OverloadingClient();
		
		client.overloadingMethod((x, y) -> x+y);

	}

	/*private void overloadingMethod(IntegerBinaryOperator<Integer> in) {
		 
		System.out.println("IntegerBinaryOperator " +in.apply(5, 6));
		
	}
	
	private void overloadingMethod(BinaryOperator<Integer> in) {
		System.out.println("BinaryOperator " +in.apply(5, 6));
		
	}*/
	
	private void overloadingMethod(BiFunction<Integer,Integer,Integer> in) {
		System.out.println("BiFunction " + in.apply(6, 7));
		
	}
}
