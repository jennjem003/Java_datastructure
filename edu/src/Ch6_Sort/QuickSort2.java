package Ch6_Sort;


//퀵 정렬(비재귀 버전)

import java.util.Scanner;

class Point {
	private int ix;
	private int iy;

	 private int[] stk;           // 스택용 배열
	 private int capacity;        // 스택의 크기
	 private int ptr;             // 스택 포인터
	 
	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
	
}

class QuickSort2 {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
 }

 //--- 퀵 정렬(비재귀 버전)---//
 static void quickSort(int[] a, int left, int right) {
     IntStack lstack = new IntStack(right - left + 1);
     IntStack rstack = new IntStack(right - left + 1);
     Point p = new Point(left,right);
     IntStack s = new IntStack(30);
//     lstack.push(left);
//     rstack.push(right);
     s.push(p);

     while (lstack.isEmpty() != true) {
         int pl = left  = lstack.pop();        // 왼쪽 커서
         int pr = right = rstack.pop();        // 오른쪽 커서
         p = s.pop();
         left = p.getX();
         right = p.getY();
         int x = a[(left + right) / 2];        // 피벗은 가운데 요소

         do {
             while (a[pl] < x) pl++;
             while (a[pr] > x) pr--;
             if (pl <= pr)
                 swap(a, pl++, pr--);
         } while (pl <= pr);

         if (left < pr) {
//             lstack.push(left);           // 왼쪽 그룹 범위의
//             rstack.push(pr);             // 인덱스를 푸시
        	 s.push(left);
        	 s.push(pr);
         }
         if (pl < right) {
//             lstack.push(pl);             // 오른쪽 그룹 범위의
//             rstack.push(right);          // 인덱스를 푸시
        	 s.push(right);
        	 s.push(pl);
         }
     }
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("퀵 정렬");
     System.out.print("요솟수: ");
     int nx = stdIn.nextInt();
     int[] x = new int[nx];

     for (int i = 0; i < nx; i++) {
         System.out.print("x[" + i + "]: ");
         x[i] = stdIn.nextInt();
     }

     quickSort(x, 0, nx - 1);            // 배열 x를 퀵정렬

     System.out.println("오름차순으로 정렬했습니다.");
     for (int i = 0; i < nx; i++)
         System.out.println("x[" + i + "]=" + x[i]);
 }
}
