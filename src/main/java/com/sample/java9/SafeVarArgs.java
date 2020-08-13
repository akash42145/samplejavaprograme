package com.sample.java9;

import java.util.Arrays;
import java.util.List;

public class SafeVarArgs {

	public static void main(String[] args) {
		
		SafeVarArgs safevar = new SafeVarArgs();
		
		System.out.println(safevar.strList("Akash ","Jee"));
		
		List<String> lst = Arrays.asList("Akash ","Jee");
		safevar.print(lst);
		String[] plants = broken("seed"); // ClassCastException
		System.out.println(unsafe(1,2,3));

	}
	
	public String[] strList(String...str){
		return str;
		
	}
	@SafeVarargs
	private void print(List<String>... topics) 
    { 
        for (List<String> topic : topics) { 
            System.out.println(topic); 
        } 
    } 
	
	@SafeVarargs
	public static <T> T[] unsafe(T... elements) {
	    return elements; // unsafe! don't ever return a parameterized varargs array
	}
	 
	public static <T> T[] broken(T seed) {
	    T[] plant = unsafe(seed); // broken! This will be an Object[] no matter what T is
	    return plant;
	}
	

}
