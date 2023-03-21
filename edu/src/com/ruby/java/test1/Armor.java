package com.ruby.java.test1;

public class Armor {
	private String name;
	private int height;
	private int weight;
	private String color;
	private boolean isFly;
	public void speedup(double value) {
		double speed = value;
	}
	public void speedup(double value,int maxValue) {
		double speed = value;
		int maxspeed = maxValue;
	}
	public void setheight(int value) {
		height = value;
	}
	public void setName() {
		String value = "mark6";
		name = value;
	}
	public int takeOff(int value) {
		System.out.println("엔진 시동 : value = " + value);
		return value -50;
	}

}
