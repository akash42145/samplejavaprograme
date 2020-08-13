package com.sample.streamGrouping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingClient {

	public static void main(String[] args) {
		
		
		List<Request> requestList = new ArrayList<Request>();
		requestList.add(new Request("INR", LocalDate.now().plusDays(1), 1.09));
		requestList.add(new Request("INR", LocalDate.now().plusDays(2), 0.0));
		requestList.add(new Request("INR", LocalDate.now().plusDays(3), 3.09));
		
		requestList.add(new Request("EUR", LocalDate.now().plusDays(2), 2.09));
		requestList.add(new Request("EUR", LocalDate.now().plusDays(3), 0.0));
		
		System.out.println(requestList.stream().count() + requestList.stream().count());
		
		
		Map<String, Map<LocalDate, Double>> response = requestList.stream().collect(Collectors.groupingBy(re -> re.getCurrency() ,Collectors.toMap(Request::getDate,Request::getRate,(oldV, newV) -> newV)));
		System.out.println(response);
		
		Map<LocalDate, Double> defaultMap = new HashMap<LocalDate, Double>();
		defaultMap.put(LocalDate.now().plusDays(1), 7.00);
		defaultMap.put(LocalDate.now().plusDays(2), 8.00);
		defaultMap.put(LocalDate.now().plusDays(3), 9.00);
		
		
		response.entrySet().stream().forEach(r -> r.getValue().entrySet().stream().forEach(p -> {
			if(p.getValue()== 0.0) {
				p.setValue(defaultMap.get(p.getKey()));
			}
		}));
		
		System.out.println(response);
		
		/*
		 * double fwd = 14.831500; double spot = 14.767000;
		 * 
		 * double monthly = (fwd/spot) -1;
		 * 
		 * double carry = Math.pow((1 + monthly),(1/31))-1;
		 * 
		 * double carry2 = Math.pow((1 + monthly),(1/31)-1);
		 * System.out.println("monthly "+ monthly);//0.436785%
		 * 
		 * System.out.println("Carry "+ carry); //0.014060
		 * System.out.println("Carry2 "+carry2); //0.014060
		 */		
		

		double fwd = 14.831500;
		double spot = 14.767000;
		 
		double monthly = (fwd/spot) -1;
		System.out.println("monthly "+ monthly);//0.436785%
		 double div = (1 / 31.0);
		 System.out.println("div "+ div); // 0.0322
		double carry = Math.pow(( monthly +1),(1/31.0))-1;		
		
		
		System.out.println("Carry "+ carry); //expected 0.014060%
		
		

	}

}
