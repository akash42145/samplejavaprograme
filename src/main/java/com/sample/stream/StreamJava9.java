package com.sample.stream;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamJava9 {

	public static void main(String[] args) {

		//Java 8 filter
		System.out.println("=========Java 8 filter =======");
		Stream.of(2, 4, 6, 8, 9, 11, 13, 18, 20).filter(e -> e % 2 == 0).forEach(a -> System.out.print(a + " " ));
		System.out.println();
		System.out.println("=========Java 9 takeWhile=======");		
		//Java 9 takeWhile (Once predicate will fail then other elements will be discarded)
		Stream.of(2, 4, 6, 8, 9, 11, 13, 18, 20).takeWhile(e -> e % 2 == 0).forEach(a -> System.out.print(a + " " ));
		System.out.println();
		System.out.println("=========Java 9 takeWhile=======");
		Stream.of( 9, 1, 3, 8, 2).takeWhile(e -> e % 2 == 0).forEach(a -> System.out.print(a + " " ));
		System.out.println();		
		//Drop while
		System.out.println("=========Java 9 drop while =======");
		Stream.of(2,9,12,7,3,6).dropWhile(e ->e %2 ==0 ).forEach(a -> System.out.print(a + " " ));
		System.out.println();		
		System.out.println("=========Java 9 drop while =======");
		Stream.of(2, 4, 6, 8, 9, 11, 13, 18, 20).dropWhile(e ->e %2 ==0 ).forEach(a -> System.out.print(a + " " ));
		System.out.println();
		System.out.println("=========Java 8 iterate with limit=======");
		Stream.iterate(5, x -> x+1 ).limit(10).forEach(a -> System.out.print(a + " " ));

		System.out.println("=========Java 8 iterate with filter =======");
		//This will print 5 6 7 8 9 and never terminates
		//Stream.iterate(5, x -> x+1 ).filter(p -> p< 10).forEach(a -> System.out.print(a + " " ));
		
		System.out.println("=========Java 9 iterate with 3 arguments =======");
		Stream.iterate(5, x -> x <11, next -> next +1).forEach(a -> System.out.print(a + " " ));
		
		
		//Strem.ofNullable
		System.out.println();
		System.out.println("=========Java 9 Stream.ofNullable =======");
		List<String> nameList = new ArrayList<>();
		nameList.add("Akash");
		nameList.add("Sagar");
		nameList.add(null);
		nameList.add("Shikha");
		//Removes null elements
		nameList.stream().flatMap(mapper -> Stream.ofNullable(mapper)).forEach(a -> System.out.print(a + " " ));
		
		System.out.println();
		System.out.println("=========Java 9 Stream.ofNullable example 2 =======");
		 

        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("Frank", "Franky");
        nickNames.put("James", "JC");
        nickNames.put("Oscar", null);
        nickNames.put("Michael", "Mike");
        nickNames.put("Herb", "Zerbi");
        nickNames.put("Elizabeth", "Lizee");
        nickNames.put("Suzy", null);
        nickNames.put("Akash", "Rinku");
        nickNames.put("Shikha", "Gupta");
        //Display Keys
        List<String> names = nickNames.entrySet()
                .stream()
                .map(e -> e.getKey())
                .collect(toList());
        System.out.println(names);

        //Display Values removing null value
        List<String> nick1 = nickNames.entrySet()
                .stream()
                .flatMap(e -> {
                    if (e.getValue() != null) {
                        return Stream.of(e.getValue());
                    } else {
                        return Stream.empty();
                    }
                })
                .collect(toList());

        System.out.println(nick1);
        
        //Display Values removing null value
        List<String> nick2 = nickNames.entrySet()
                .stream()
                .flatMap(e -> Stream.ofNullable(e.getValue()))
                .collect(toList());
        System.out.println(nick2);
        
        //Java 8 sort map by key
        Map<String, String> nickNames2 = nickNames.entrySet().stream().filter(p -> p.getValue() != null).collect(toMap(e -> e.getKey(),e -> e.getValue(), (oldV, newV) -> newV, LinkedHashMap::new));
        System.out.println(nickNames2);
        
        //Java 8 sort map by key        
		Map<String, String> sortedByKeyNickNames = nickNames.entrySet().stream().filter(p -> p.getValue() != null)
				.sorted(comparingByKey(Comparator.naturalOrder()))
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (oldV, newV) -> newV, LinkedHashMap::new));
        System.out.println(sortedByKeyNickNames);
        
        
        //java 8 sort map by value  by length         
		Map<String, String> sortedByValueNickNames = nickNames.entrySet().stream().filter(p -> p.getValue() != null)
				.sorted(comparingByValue(comparing(key -> key.length())) )
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (oldV, newV) -> newV, LinkedHashMap::new));
        System.out.println(sortedByValueNickNames);
        
		// 1. java 8 sort map by value (First by length , if same lengh then alphabatical order)
		Map<String, String> sortedByValueNickNames1 = nickNames.entrySet().stream().filter(p -> p.getValue() != null)
				.sorted(comparingByValue((c1, c2) -> {
						if (c1.length() == c2.length()) {
							return c1.compareTo(c2);
						} else if (c1.length() > c2.length()) {
							return 1;
						} else {
							return -1;
						}
				}

				)).collect(toMap(e -> e.getKey(), e -> e.getValue(), (oldV, newV) -> newV, LinkedHashMap::new));
        System.out.println(sortedByValueNickNames1);
        
		// 2. java 8 sort map by value (First by length , if same length then
		// alphabatical order)
		Map<String, String> sortedByValueNickNames2 = nickNames.entrySet().stream().filter(p -> p.getValue() != null)
				.sorted(comparingByValue(comparingInt(c -> c.length())))
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (oldV, newV) -> newV, LinkedHashMap::new));
		System.out.println(sortedByValueNickNames2);
	}

}
