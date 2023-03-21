package edu.mission;

import java.util.Scanner;

public class Mission8 {
//	public static void prime(int num) {
//		System.out.println("입력 숫자:" + num);
//	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System. in)) {
			//System.out.print("Number:");
			//Scanner sc = new Scanner(System.in);
			System.out.print("Number:");
			int num = sc.nextInt();
			
			boolean isPrime = true;
			
			for(int i = 2; i <= num/2; i++) {
				if(num % i == 0) {
					isPrime=false;
					return;
					
				}
			}
//			while((num = sc.nextInt()) != 0) {
//				
//				prime(num);
//				
//			System.out.println("Number:");
//			}

		System.out.printf(isPrime ? "소수입니다." : "소수가 아닙니다.");
		
		}
		
	}
}


