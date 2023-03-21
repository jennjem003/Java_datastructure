package edu.mission;

public class Mission4 {
	
	public static void printArray(int[][] arr) {
		for (int i = 0;i<arr.length ;i++) {
			for(int j = 0 ; j <arr[0].length;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {

		int[][] A = {{1,2,3,4},
				{5,6,7,8},{9,10,11,12}};
		int[][] B = {{1,2,3},
				{4,5,6},{7,8,9},{10,11,12}};
		int[][] C = new int [3][3];
		
		printArray(A);
		System.out.print("\n");
		printArray(B);
		System.out.print("\n");
		
		for (int i = 0; i<A.length; i++) {
			for (int j = 0 ; j<B[0].length;j++) {
				for(int k = 0; k<B.length;k++) {
				C[i][j] += A[i][k]*B[k][j];}
			}
		}
		printArray(C);
	}

}
