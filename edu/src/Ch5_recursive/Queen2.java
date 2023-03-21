package Ch5_recursive;


class Point {
	private int x;
	private int y;
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
}

class MyStack{
	private int top;
	private Point[] data;
	
	public MyStack() {
		top =0;
		data = new Point[100];//선언한 포인트에 포인트 배열의 크기
	}
	public void push(Point p) {
		data[top++] = p;//top에 0번째 넣고 차례대로
	}
	public Point pop() {
		return data[--top];//위에서 부터 내려오는거라서 --
	}
	public Boolean isEmpty() {
		if(top == 0) {
			return true;}
		return false;
		
		
	}
}
public class Queen2 {
	
	public static boolean checkMove(int x,int y,int[][] array) {
		if(! (checkRow(x,array))) return false;
		if(! (checkCol(y,array))) return false;
		if(! (checkDiagSW(x,y,array))) return false;
		if(! (checkDiagSE(x,y,array))) return false;
		return true;
	}
	
	private static boolean checkDiagSE(int x, int y, int[][]array) {
		int dx = x;
		int dy = y;
		while(dx >=0 && dx< array[y].length && dy>=0 && dy<array[x].length) {
			if(array[dx][dy] == 1)
				return false;
			dx ++;
			dy --;
		}
		dx = x ;
		dy = y;
		while(dx >=0 && dx< array[y].length && dy>=0 && dy<array[x].length) {
			if(array[dx][dy] == 1)
				return false;
			dx --;
			dy ++;
		}
		return true;
	}

	private static boolean checkDiagSW(int x, int y, int[][]array) {
		int dx = x;
		int dy = y;
		while(dx >=0 && dx< array[y].length && dy>=0&&dy<array[x].length) {
			if(array[dx][dy] == 1)
				return false;
			dx ++;
			dy ++;
		}
		dx = x ;
		dy = y;
		while(dx >=0 && dx< array[y].length && dy>=0&&dy<array[x].length) {
			if(array[dx][dy] == 1)
				return false;
			dx --;
			dy --;
		}
		return true;
	}

	private static boolean checkCol(int y,int[][] array) {
		for(int i = 0; i <array[y].length;i++) {
			if(array[i][y]==1)
				return false;
		}
		return true;
	}

	private static boolean checkRow(int x,int[][] array) {//x는 고정,y만 돌림/1이있으면 f,없으면t
		for(int i = 0; i <array[x].length;i++) {
			if(array[x][i]==1)
				return false;
		}
		return true;
	}

	private static void solveQueen(int row,int col, int[][]array) {
		MyStack s = new MyStack();
		Point p = new Point(0, 0);//초기화 되는 것
		int x = p.gety();
		int y = p.gety();
		int flag = 0;
		while(true) {
			while(x<row) {
				while(y<col) {
					if (checkMove(x,y,array)) {
						array[x][y]=1;
						s.push(new Point(x,y));
						y=0;
						break;
					}
					y++;
				}
				x++;
				if (y >= col) {
	                if (!s.isEmpty()) {
	                    p = s.pop();
	                    x = p.getx();
	                    y = p.gety();
	                    array[x][y] = 0;
	                    y++;//갈데가 있으면
	                } else {
	                    flag = 1;
	                    break;//갈데가 없을때
	                }
				}
			}
			if(flag==1)break;
			printBoard(row,col,array);
			p = s.pop();
			x = p.getx();
			y = p.gety();
			array[x][y] = 0;
			y++;
		}
		}
	static int num = 0;
	public static void printBoard(int row, int col, int[][] array) {
		System.out.println(++num);
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		int row = 8;
		int col= 8;
		int[][] array =new int[row][col];
		
		for(int i =0; i<row; i++) {
			for(int j =0; j<col; j++) {
				array[i][j]=0;
			}
		}
		solveQueen(row,col,array);
	}

}
