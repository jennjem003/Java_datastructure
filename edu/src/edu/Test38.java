package edu;

public class Test38 {

//	private static int num;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[ ][ ]arr = new int[5][5];
		int a[][] =new int[5][5];
		int b[][] =new int[5][5];
		int c[][] =new int[5][5];
		//int num = 1;
		//double rnum = Math.random();
		//int num = (int)(rnum *10);
		
		for(int i =0; i < arr.length;i++) {
//			for(int j =0; j < arr[i].length;j++ ){
//				arr[i][j] = num++;
//			}
		}
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<a[0].length;j++) {
				double rnum = Math.random();
				int num = (int)(rnum *10);
				a[i][j] = num;
			}
			System.out.println("\n");
		}
		for(int i = 0; i<b.length; i++) {
			for(int j = 0; j<b[0].length;j++) {
				double rnum = Math.random();
				int num = (int)(rnum *10);
					b[i][j] = num;
			}
			System.out.println("\t");
		}}}	
////		for(int i = 0; i<c.length; i++) {
////			for(int j = 0,1) {
////			for(int k=0; a[0].length;k++) {
//////				double rnum = Math.random();
//////				int num = (int)(rnum *10);
////				System.out.println(c);
////			}
////	}
////	}
////}
////}
