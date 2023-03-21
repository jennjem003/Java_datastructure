package com.ruby.java.ch13.multiGen;


package com.ruby.java.ch13.multiGen;

class Bag<T, N> {
	private T thing;
	private N name;

	public Bag(T thing, N name) {
		this.thing = thing;
		this.name = name;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}

	public N getName() {
		return name;
	}

	public void setName(N name) {
		this.name = name;
	}

	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
		System.out.println("N의 타입은 " + name.getClass().getName());
	}
}