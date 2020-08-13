package com.sample.innerclass;

public class InnerClassTest {
	  class Inner{

		public  void check() {
			if(flag == true) {
				System.out.println("Sample");
			}
			
		}

		
		 
	 }
	 
	 private  boolean flag = true;

	public static void main(String[] args) {
		new InnerClassTest().doStuff();

	}

	private void doStuff() {
		 new Inner().check();
		
	}

}
