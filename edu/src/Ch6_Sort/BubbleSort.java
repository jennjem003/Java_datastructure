package Ch6_Sort;

//버블 정렬(단순 교환 정렬) (버전 1)

import java.util.Scanner;

class BubbleSort {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
 }

 //--- 버블 정렬 ---//
 static void bubbleSort(int[] a, int n) {
	 //int excg = 0; // 한번이라도 1이 되면 브레이크 될 일 없음. 계속 if문 돌아가
	 int count = 0;
     for (int i = 0; i < n - 1; i++) 
     {
    	 int excg = 0; // 바깥의 for문이 패스가 되서 돌 때마다 리셋이 된다. 조기종료 된다는 말?
         for (int j = n - 1; j > i; j--) {
             if (a[j - 1] > a[j]) {
            	 
                 swap(a, j - 1, j);
     			 excg++;
     		}
         count ++;
     	}
     	if (excg == 0) break;
     }
     //System.out.println("브레이크 된 갯수 : " + excg);
     System.out.println("count = " + count);
}

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("버블 정렬(버전 1)");
     System.out.print("요솟수: ");
     int nx = stdIn.nextInt();
     int[] x = new int[nx];

     for (int i = 0; i < nx; i++) {
    	 //Double d = Math.random();
    	 //x[i] = (int)(d*20);
         System.out.print("x[" + i + "]: "); // 8 -> 6 4 3 7 1 9 8 5
         x[i] = stdIn.nextInt();
    	 
     }
     for(int num : x)
    	 System.out.println(" "+num);
     System.out.println();

     bubbleSort(x, nx);                // 배열 x를 단순교환정렬

     System.out.println("오름차순으로 정렬했습니다.");
     for (int i = 0; i < nx; i++)
         System.out.println(" " + x[i]);
 }
}
