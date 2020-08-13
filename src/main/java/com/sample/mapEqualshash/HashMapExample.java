package com.sample.mapEqualshash;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Employee,PersonalDetail> map = new HashMap<>();
		
		Employee e1 = new Employee(101, "Name101");
		PersonalDetail p1 = new PersonalDetail(1111, "Noida");
		
		map.put(e1, p1);
		
		System.out.println(map.containsKey(e1));
		System.out.println(map.containsKey(new Employee(101, "Name101")));
		System.out.println(e1.hashCode());
		e1.setEid(1101);
		System.out.println(map.containsKey(e1));
		System.out.println(e1.hashCode());
		e1= null;
		
		System.out.println(map.containsKey(e1));
		System.out.println(e1.hashCode());
	}

}
