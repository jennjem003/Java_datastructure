package edu.mission;

import java.util.Scanner;

public class Mission6 {

	/*
	 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
	 * int max = sc.nextInt(); int min = sc.nextInt(); int rem = max%min; }
	 * 
	 * private static int GCD(int i, int j) { if(max % min == 0) { return min } }
	 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("두 수를 입력하시오.");
        a = sc.nextInt();
        b = sc.nextInt();

        int result = gcd(a, b);
        System.out.println("최대공약수: " + result);
        System.out.println("최소공배수: " + a * b / result);
    	}

    	static int a, b;
    
    public static int gcd(int a, int b) {
        int gcd = 0;
        while (b > 0) {
            gcd = a % b;
            a = b;
            b = gcd;
        }
        return a;
    }
}


