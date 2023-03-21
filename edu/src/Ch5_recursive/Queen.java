package Ch5_recursive;

import java.util.Stack;


/*class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public String toString() {
		return "<" + ix + ", " + iy + ">";
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
}*/

 class genericStack {
	//--- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;
		public EmptyGenericStackException() {
			super();
		}
	}

	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}

    private Point data[];           // 스택용 배열
	//private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public genericStack(int capacity) {
		top = 0;
		this.capacity = capacity;
		// this.data = new T[capacity]; // 스택 본체용 배열을 생성
		try {
		data = new Point[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}	
	}

//--- 스택에 x를 푸시 ---//
	public Point push(Point x) throws OverflowGenericStackException {
		System.out.println("top = " + top +"capacity = " + capacity);
		if (top >= capacity)
			throw new OverflowGenericStackException();
		return data[top++] = x;
			
	}
	
//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException  {
		if (top <= 0)
			throw new EmptyGenericStackException();
		return data[--top];
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException  {
		if (top <= 0)
			throw new EmptyGenericStackException();
		return data[top - 1];
	}

//--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data[i].equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("stack이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data[i] + " ");
			System.out.println();
		}
	}
}
public class Queen{	

	/*
	 * public static void main(String[] args) { int [][] data = null; int x = 0; int
	 * y = 0; int count = 1;
	 * 
	 * SolveQueen(data);
	 * 
	 * }
	 * 
	 * private static void SolveQueen(int[][] data) { while() {
	 * 
	 * }
	 * 
	 * } boolean CheckMove(int currentRow, int row, int col) { currentRow(x);
	 * 
	 * }
	 */
	static boolean[] flag_a = new boolean[8]; //각 행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15]; // / 대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15]; // \ 대각선 방향으로 퀸을 배치했는지 체크
    static int[] pos = new int[8]; //각 열의 퀸의 위치
    
    void SolveQueen(int [][]d) {
    	int count = 0;
    	int x = 0;
    	int y = 0;
    	
    	Stack<Integer> s = new Stack<>();
    	//pop
    	Point p =new Point(x,y);
    	s. push(0);
    	d[x][y] = 1;
    	
    	while(count <= d.length){		
    		x ++;
    		y = NextMove(data,x,y);
    				
    		count ++;
    	}

    }
    
  //코딩 완성하기 

    //각 열의 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.print(pos[i] + " ");
        }
        System.out.println();
    }

  void NextMove(int[] move, int row); // current row에 대한 다음 배치 가능한 모든 column을 조사하고 move[]에 1로 설정
  boolean CheckMove(int currentRow[][], int row, int col) {
	  //currentRow에 대하여 queen을 (x,y)에 배치 가능하면 true
	  
//	  for(int i =col; i>=0;i--) {
//		  if(currentRow[row][i]==1)
//			  return false;
//	  }
//	  int i = row,j=col;
//	  while(i>0 && j>=0) {
//		  if(currentRow[i][j] == 1)
//			  return false;
//		  i--;
//		  j--;
//	  }
//	  i=row;
//	  j=col;
  }

// => backtracking을 stack을 이용하여 push/pop으로 해결하는 것을 보이는 것임
//
//-> 가로, 세로, 대각선에 대한 충돌 체크 함수 코딩
boolean CheckMove(x,y) {
checkRow(x);
checkCol(y);
checkDiagSW(x,y); //x++, y-- or x--, y++ where 0<= x,y <= 7
checkDiagSE(x,y); //x++, y++ or x--, y--
//}

    public static void main(String[] args) {
    	int [][]data = new int [4][4];
//     	배열 초기화
//    	SolveQueen(data);
//    	배열열 출력: 8개의 queen 배치(여러가지 해를 구해 보여주기)
    //  }
        
    }
}
	

