package edu.mission;

import java.util.Scanner;

public class Misson3 {

	public static void main(String[] args) {
/*		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i =0;
		int[] arr = new int[i];
		int j =0;
		
		while(n>0) {
			arr[j] = n%2;
			n /= 2;
			System.out.println(n%2+"/t");
			j++;
			//if(2 > i)
				//break;
		}
		//System.out.println("값 : ");
	}
*/

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
 
        String i = Integer.toBinaryString(n);
 
        System.out.println(i);
    
	}
}
