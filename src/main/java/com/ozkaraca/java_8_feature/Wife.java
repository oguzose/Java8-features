package com.ozkaraca.java_8_feature;

import java.util.List;
import java.util.stream.Stream;

public class Wife {
	
	String name;
	
	List<Child> children;
	
	
	public Wife(String name, List<Child> children) {
		super();
		this.name = name;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Wife [name=" + name + ", children=" + children + "]";
	}
	
}
