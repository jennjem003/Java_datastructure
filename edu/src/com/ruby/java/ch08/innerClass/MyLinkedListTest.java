package com.ruby.java.ch08.innerClass;

public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		myList.print();
		//myList
		myList.add("JAVA");
		myList.add("JSP");
		myList.add("Servlet");
		myList.print();
		//MyLinkedList.Node nd = myList.new Node("Hong");
		//nd.data = "hello";
	}
}