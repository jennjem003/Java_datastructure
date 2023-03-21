package com.ruby.java.ch11;

public class Test01 {

	public static void main(String[] args) {
		test();
	}
	public static void test() {
		
		try {
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length();
			int arr[] = new int[3];
			arr[3] = 30;
			System.out.println("OK");
		} catch (ArrayIndexOutOfBoundsException e) {
			//catch (Exception e) {
			System.out.println("잘못된 배열의 인덱스 사용!");
		} catch (NullPointerException e2) {
			e2.printStackTrace();
			System.out.println("잘못된 참조!"+ e2.getMessage());
		}
		System.out.println("GOOD");
	}
}
