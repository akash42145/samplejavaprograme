package com.sample.gc;

import java.util.ArrayList;
import java.util.List;

public class GCExample {

	public static void main(String[] args) {
		List<String> lst = new ArrayList<>();
		lst.add("One");
		lst.add("Two");
		lst.add("Three");
		
		print(lst);
		System.out.println(lst.size());
	}

	private static void print(List<String> lst) {
		 String val = lst.get(1);
		 
		 lst.add("four");
		 
		 lst = null;
		 
		 System.out.println(val);
		
	}

}
