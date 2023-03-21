package Ch4;

public class PointQueue {
    private int[] data;            // 큐용 배열
    private int capacity;         // 큐의 크기
    private int front;            // 맨 처음 요소 커서
    private int rear;             // 맨 끝 요소 커서

    //실행 시 예외: 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
    	public EmptyIntQueueException() {}
    }
    
    //실행 시 예외: 큐가 가득참 
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }
    
    //생성자
    public PointQueue(int capacity) {
    	front = rear = 0;
    	this.capacity = capacity;
    	try {
    		data = new int[capacity];
    	} catch (OutOfMemoryError e) {
    		capacity = 0;
    	}
    }
    
    // 큐에 데이터 PointQueue
    //public Point 
}