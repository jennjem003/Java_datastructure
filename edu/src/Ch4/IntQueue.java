package Ch4;

//int형 고정 길이 큐 아이템 객체를 que에 집어넣어.흠

public class IntQueue {
private Object[] que;            // 큐용 배열
//private int capacity;         // 큐의 크기
private int front;            // 맨 처음 요소 커서
private int rear;             // 맨 끝 요소 커서
private int maxlen;
//private int num;              // 현재 데이터 개수
static boolean isEmpty; 

public class EmptyIntQueueException extends RuntimeException {
   public EmptyIntQueueException() { }
}

//--- 실행시 예외: 큐가 가득 찼음 ---//
public class OverflowIntQueueException extends RuntimeException {
   public OverflowIntQueueException() { }
}

//--- 생성자(constructor) ---//
public IntQueue(int maxlen) {
   this.front = 0;
   this.rear = -1;
   
   //실제 크키보다 하나더 크게 지정한다
   this.maxlen = maxlen + 1;
   this.que = new Object[this.maxlen];
}


public boolean isEmpty() {
  return (front == rear +1) || (front + maxlen-1 == rear);
}


public boolean isFull() {
  return (rear == maxlen -1) || (front + maxlen-2 == rear);
}


//--- 큐에 데이터를 인큐 ---//
public Object enque(Object x) {
   if(isFull()) throw new OverflowIntQueueException();
   //rear 가 배열의 마지막이면 앞으로 돌린다.
   if(rear == maxlen-1) {
  	 rear = -1;
   }
   return que[++rear] = x;
}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---// 조회
public Object peek() throws EmptyIntQueueException {
  if (isEmpty()) throw new EmptyIntQueueException();  
  return que[front];
}

//--- 큐에서 데이터를 디큐 ---//
public Object deque(){
   Object x = peek();
   front++;
   
   if(front == maxlen) {
  	 front = 0;
   }
   return x;
}
public void dump() {
   if (maxlen <= 0)
       System.out.println("큐가 비어있습니다.");
   else {
       for (int i = 0; i < maxlen; i++)
           System.out.print(que[(i + front) % maxlen] + " ");
       System.out.println();
   }
}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
public Object indexOf(Object x) {
   for (int i = 0; i < maxlen; i++) {
       int idx = (i + front) % maxlen;
       if (que[idx] == x)                
           return idx;
   }
   return -1;                            
}


}