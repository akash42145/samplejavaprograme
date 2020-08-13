package com.sample.exception;

import java.lang.reflect.Field;

public class TryFinally {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		int result = tryExpFinally();
		
		System.out.println(result);
		
		String user = "guest";
		System.out.println("User is of type: " + user);

		Class<String> type = String.class;
		Field field = type.getDeclaredField("value");
		field.setAccessible(true);

		char[] chars = (char[]) field.get(user);

		chars[0] = 'a';
		chars[1] = 'd';
		chars[2] = 'm';
		chars[3] = 'i';
		chars[4] = 'n';

		System.out.println("User is of type: " + user);

		
		
	}

	private static int tryExpFinally() {
		int a = 0;
		try {
			
			a= 10/0;
			return a;
		} catch (Exception e) {
			a =15;
			return a;
		}
		finally {
			a= 20;
			//return a;
		}
		
		
	}
	
	

}
