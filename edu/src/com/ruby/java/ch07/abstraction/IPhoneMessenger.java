package com.ruby.java.ch07.abstraction;

public class IPhoneMessenger implements Messenger{
	public String getMessage() {
		return "Iphone";
	}
	public void setMessage(String msg) {
		System.out.println("mesg"+msg);
	}

}
