package com.ruby.java.ch07.inheritance;

public class Person {
	private String name;
	private int age;
	//public Person(String ssd_ID) {
		//this.ssd_ID = ssd_ID;
//	private final String ssd_ID;
//	public void setssd_ID() {
//		this.ssd_ID = ssd_ID;
//	}
	
	public Person() {
		System.out.println("Person 클래스 생성");
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person 클래스 생성");
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

	public String toString() {
		return name + ":" + age;
	}
}