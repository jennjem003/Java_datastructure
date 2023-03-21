package edu;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[]arr = {1,2,3,4,5};
		int [] arr = new int[20];
		for(int i = 0; i < arr.length; i++)
			arr[i] = i * 10;
		//int [ ] a = {1,2,3,4,5};
		/* for (int i = 0; i<5; i++) */
			/*
			 * arr[0] = 10; //arr의 0번지에 10 저장 arr[i] = i*10;
			 */
		/*
		 * arr[1] = 20; arr[2] = 30; arr[3] = 40; arr[4] = 50;
		 */
		
		//System.out.println(arr[0]); //arr의 0번지 값 출력
		/*
		 * System.out.println(arr[1]); System.out.println(arr[2]);
		 * System.out.println(arr[3]); System.out.println(arr[4]);
		 */
		//for ( int i = 0; i<5; i++)
		//System.out.println(arr[i]);
		//System.out.print(" "+arr[i]);
		for (int num:arr)
			System.out.print(" " + num);
		System.out.println();
		System.out.println("훈세");
	}

}
