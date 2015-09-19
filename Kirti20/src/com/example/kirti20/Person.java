package com.example.kirti20;

public class Person {
	String fName;
	String lName;
	
	
	
	public Person(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}



	@Override
	public String toString() {
		return fName + "," + lName ;
	}
	
	
	

}
