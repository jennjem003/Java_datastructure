package Queeen;

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
	public Point push(Point p) throws OverflowGenericStackException {
		System.out.println("top = " + top +"capacity = " + capacity);
		if (top >= capacity)
			throw new OverflowGenericStackException();
		return data[top++] = p;
			
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

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		this.ix = x;
		this.iy = y;
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
}
public class Queen_1 {

//- 함수 호출로 구현 훈련
  static void SolveQueen(int [][]data) {
	int count = 0; //point 스텍
	int x = 0; //행
	int y = 0; //열


	Point p = new Point(x, y);
	genericStack s = new genericStack(100);
	s.push(p);
	data[x][y] = 1;
	
	while(count < data.length) {
		x++;
		y = 0;
		while (y > data.length) {// y값을 증가하여 반복
			y = NextMove(data, x, y);
			if(y == 1) {
				y++;
			}
			if (y == -1) {
				//pop 처리
				try {
					s.pop();
				} catch (EmptyGenericStackException e) {
					e.printStackTrace();
				}
			}
			if(y < data.length) {
				data[x][y] = 1;
				p = new Point(x,y);
				s.push(p);
				y = 0;
				break;
			} else {
			data[x][y] = 1;
			try {
				s.pop();
			} catch (EmptyGenericStackException e) {
				e.printStackTrace();
			}
			p.getX();
			p.getY();
			y--;
			}
		y++;
		count++;
			}
		}
	}

	  private static int NextMove(int[][] data, int x, int y) {
		  while (y < data.length) {
		  if (CheckMove(data,x,y)) return y;
		  y++;
		  }
		  return -1;
	  }
	  static boolean CheckMove(int [][]data, int row, int col) {
		  if(CheckRow(data, row) && CheckCol(data, col) &&
			 CheckDiagSW(data, row, col) && CheckDiagSE(data, row, col))
		  return true;
		  else return false;
	  }
	  static boolean CheckRow(int [][]data, int row) {
		  for(int i = 0; i < data[row].length; i++) {
			  if(data[row][i]==1)
				  return true;
		  }
		  return false;
	  }
	  
	  static boolean CheckCol(int [][]data, int col) {
		  for(int i = 0; i < data[col].length; i++) {
			  if(data[i][col]==1) return true;
		  }
		  return false;
	  }
	  
	  static boolean CheckDiagSW(int [][]data, int row, int col) {
		  int dx = row;
		  int dy = col;
		  while(dx >= 0 && dx < data[col].length && dy>=0 && < data[row].length) {
			  if(data[dx][dy] == 1) {
				  return false;
				  dx--;
				  dy++;
			  }
			  return true;
		  }
		dx = row;
		dy = col;
			  
		 while(dx >= 0 && dx < data[col].length && dy>=0 && < data[row].length) {
			  if(data[dx][dy] == 1) {
				  return false;
				  dx++;
				  dy--;
			  }
			  return true;
		 }
	  }
		 
	  static boolean CheckDiagSE(int[][]data, int row, int col) {
		  int dx = row;
		  int dy = col;
		  while(dx >= 0 && dx < data[col].length && dy>=0 && < data[row].length) {
			  if(data[dx][dy] == 1) {
				  return false;
				  dx++;
				  dy--;
			  }
			  return true;
		  }
		dx = row;
		dy = col;
			  
		 while(dx >= 0 && dx < data[col].length && dy>=0 && < data[row].length) {
			  if(data[dx][dy] == 1) {
				  return false;
				  dx--;
				  dy++;
			  }
			  return true;
		 }
	  }

	public static void main(String[] args) {
		//입력 출력 호출
		int row = 8;
	 	int col = 8;
		int[][] data = new int[row][col];
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data.length; j++) {
				data[i][j] = 0;
			}
			System.out.println(data);
		}
	  
		//배열 초기화		
	 	SolveQueen(data);
	 	
	 	//배열열 출력: 8개의 queen 배치(여러가지 해를 구해 보여주기)
	 	
	}
}
