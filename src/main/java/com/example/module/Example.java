package com.example.module;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Example {

	public static void main(String[] args) {
		
		Map<String, Integer> map = null;//new HashMap<>();
		
		int endWeight =5;
		
		map.put("1", 1);
		map.put("2", 2);
		System.out.println(map);
		
		for(Entry<String, Integer> entry : map.entrySet()) {
			map.put(entry.getKey(), entry.getValue() * 100);
		}
		 
		int result = endWeight !=0 ? map != null ? map.get("1") != null ?  map.get("1") + endWeight : 0 :0 : 0;
		
		System.out.println(result);
		
		//System.out.println(map);
		int result2 = endWeight !=0 ? map != null ? map.get("82") != null ?  map.get("82") + endWeight : 0 : 0 : 0;
		System.out.println(result2);
		
		if(endWeight !=0 && map != null && map.get("82") != null ) {
			System.out.println( map.get("82") + endWeight);
		}
		else {
			System.out.println(0);
		}
	}

}
