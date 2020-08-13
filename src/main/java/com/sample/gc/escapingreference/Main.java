package com.sample.gc.escapingreference;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));
				
		for (Customer next : records.getCustomers().values())
				{
					System.out.println(next);
				}
		
		System.out.println("==============");

		for(Customer c : records) {
			System.out.println(c);
		}
	}
	
}
