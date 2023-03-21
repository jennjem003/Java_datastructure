package com.ruby.java.ch09;

public class Test03 {

	public static void main(String[] args) {
		
		String s = "have a good day!";
		
		int Iength = s.length();
		System.out.println("총 글자 수 : " + Iength);
		char c;
		
		for(int i = 0; i < Iength; i++) {
			c = s.charAt(i);
			if(c == ' ') {
				System.out.println();
			} else {
				System.out.print(c);
			}

		}
	}

}
