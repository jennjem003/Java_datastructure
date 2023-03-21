package edu.mission;

public class Missiion2 {

	public static void main(String[] args) {
		int a =50000;
		int b =10000;
		int c =5000;
		int d =1000;
		int total = 152365;
		
		int A = total/a;
		int B = (total-a*A)/b;
		int C = (total-a*A-b*B)/c;
		int D = (total-a*A-b*B-c*C)/d;
		
		System.out.println("5만원권 : "+ A);
		System.out.println("1만원권 : "+ B);
		System.out.println("5천원권 : "+ C);
		System.out.println("1천원권 : "+ D);
	
		
	}
}