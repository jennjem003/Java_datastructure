package Ch6_Sort;

//단순 삽입 정렬

import java.util.Scanner;

class InsertionSort {
 //--- 단순 삽입 정렬 ---//
 static void insertionSort(int[] a, int n) {
     for (int i = 1; i < n; i++) {
    	 for(int num:a) {
    		 System.out.print(" "+num);
    	 }
    	 System.out.println();
         int j;
         int tmp = a[i];
         for (j = i; j > 0 && a[j - 1] > tmp; j--)//돌려서 뺀 카드 비교해서 tmp보다 크면 뒤로
             a[j] = a[j - 1];//이동한다
         a[j] = tmp;//insert
     }
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

		/*
		 * System.out.println("단순 삽입 정렬"); System.out.print("요솟수: "); int nx =
		 * stdIn.nextInt(); int[] x = new int[nx];
		 * 
		 * for (int i = 0; i < nx; i++) { System.out.print("x[" + i + "] : "); x[i] =
		 * stdIn.nextInt(); }
		 */
     //int[]x= {6,4,1,7,3,9,8};
     int[]x= {1,2,3,4,5,0,6};
     int nx = 7;
     insertionSort(x, nx);        // 배열 x를 단순삽입정렬

     System.out.println("오름차순으로 정렬했습니다.");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
 }
}
