package com.sample.map.partition;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;



public class PartitionMap {
	
	static Map<String, SecurityData> masterMap = new HashMap<String, SecurityData>();
	
	

	public static void main(String[] args) {
		String str = "500,400,600";
		List<Integer> swapInstrumenttype = Stream.of(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(swapInstrumenttype);
		
		populate(masterMap);
		
		Map<Boolean, Map<String, SecurityData>> mapmap=
		masterMap.entrySet().stream()
				.collect(Collectors.partitioningBy(p -> swapInstrumenttype.contains(p.getValue().getInstrumentType()), Collectors.toMap(k -> k.getKey(), v -> v.getValue())));				
				
		System.out.println(mapmap);
		
		System.out.println(mapmap.get(true).keySet());
		
		System.out.println(mapmap.get(false).keySet());
		
		StringJoiner j = new StringJoiner(",");
		j.add("akasha");
		
		System.out.println(j.length());
		
		Stream<Integer> s1 = Stream.of( 1, 2, 3);
		
		Stream<Integer> s2 = Stream.empty();//Stream.of( 0, 5, 3);
		
		Stream.concat(s1,  s2).forEach(System.out::println);;
		
		System.out.println(masterMap.keySet());
		
		

	}



	private static void populate(Map<String, SecurityData> masterMap) {
		masterMap.put("5", new SecurityData("USD", 500));
		masterMap.put("1", new SecurityData("USD", 100));
		masterMap.put("2", new SecurityData("USD", 200));		
		masterMap.put("6", new SecurityData("USD", 600));
		masterMap.put("7", new SecurityData("USD", 700));
		masterMap.put("3", new SecurityData("USD", 300));
		masterMap.put("4", new SecurityData("USD", 400));
		
	}



	

}
