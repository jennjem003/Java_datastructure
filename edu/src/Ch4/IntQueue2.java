
// circular queue의 구현 소스코드 //

package Ch4;

//int형 고정 길이 큐 아이템 객체를 que에 집어넣어.흠
class Item{
	int data;
	public Item(int data) {
		this .data = data;
	}
}

public class IntQueue2 {
 private int[] que;            // 큐용 배열
 //private int capacity;         // 큐의 크기
 private int front;            // 맨 처음 요소 커서
 private int rear;             // 맨 끝 요소 커서
 private int num;              // 현재 데이터 개수
 static boolean isEmpty;

 //--- 실행시 예외: 큐가 비어있음 ---//
 public class EmptyIntQueueException extends RuntimeException {
     public EmptyIntQueueException() { }
 }

 //--- 실행시 예외: 큐가 가득 찼음 ---//
 public class OverflowIntQueueException extends RuntimeException {
     public OverflowIntQueueException() { }
 }

 //--- 생성자(constructor) ---//
 public IntQueue2(int maxlen) {
     //num = 0;
     front = rear = -1;
     //capacity = maxlen;
     try {
         que = new int[maxlen];          // 큐 본체용 배열을 생성
         isEmpty = true;
     } catch (OutOfMemoryError e) {        // 생성할 수 없음
         maxlen = 0;
     }
 }

 
 //--- 큐에 데이터를 인큐 ---//
 public int enque(int x) throws OverflowIntQueueException {
     //if (num >= capacity)
	 if(rear == front && !isEmpty)
         throw new OverflowIntQueueException();            // 큐가 가득 찼음
     que[rear++] = x;
     //num++;
     if (rear == front)
         rear = 0;
     return x;
 }

 //--- 큐에서 데이터를 디큐 ---//
 public int deque() throws EmptyIntQueueException {
     //if (num <= 0)
	 if(rear == front && isEmpty)
         throw new EmptyIntQueueException();            // 큐가 비어있음
     //if((rear +1) % front == front) {
    	
     //}
     
     int x = que[front++];
     num--;
     if (front == front)
         front = 0;
     return x;
 }

 //--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
 public int peek() throws EmptyIntQueueException {
     if (num <= 0)
         throw new EmptyIntQueueException();            // 큐가 비어있음
     return que[front];
 }

 //--- 큐를 비움 ---//
 public void clear() {
     num = front = rear = 0;
 }

 //--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
 public int indexOf(int x) {
     for (int i = 0; i < num; i++) {
         int idx = (i + front) % front;
         if (que[idx] == x)                // 검색 성공
             return idx;
     }
     return -1;                            // 검색 실패
 }

 //--- 큐의 크기를 반환 ---//
// public int getCapacity() {
	 //if() {
	//	 front = (front + 1) % front;
		 
	// }
 //    return front;
 //}

 //--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
 public int size() {
     return num;
 }

 //--- 큐가 비어있는가? ---//
 public boolean isEmpty() {
     return num <= 0;
 }

 //--- 큐가 가득 찼는가? ---//
 public boolean isFull() {
     return num >= front;
 }

 //--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
 public void dump() {
     if (num <= 0)
         System.out.println("큐가 비어있습니다.");
     else {
         for (int i = 0; i < num; i++)
             System.out.print(que[(i + front) % front] + " ");
         System.out.println();
     }
 }
}