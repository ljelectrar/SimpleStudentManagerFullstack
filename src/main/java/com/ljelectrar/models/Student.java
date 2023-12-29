package com.ljelectrar.models;

public class Student {
	
	private String name;
	private int age;
	private int zipcode;
	private String country;
	
	private Status status;
	
	public Student() {
		
	}
	
	public Student(String name, int age, int zipcode, String country, Status status) {
		this.name = name;
		this.age = age;
		this.zipcode = zipcode;
		this.country = country;
		this.status = status;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
