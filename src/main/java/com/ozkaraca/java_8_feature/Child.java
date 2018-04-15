package com.ozkaraca.java_8_feature;

public class Child {
	
	String name;
	
	int age;
	
	public Child(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Child [name=" + name + ", age=" + age + "]";
	}
	

}
