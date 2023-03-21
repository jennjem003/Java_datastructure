package Chap10_Hash;

//체인법에 의한 해시

public class ChainHash<K,V> {

 //--- 해시를 구성하는 노드 ---//
 class Node<V> {
     //private K key;                 // 키값
     private V data;                // 데이터
     private Node<V> next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

     //--- 생성자(constructor) ---//
     Node(K key, V data, Node<V> next) {
         
         this.data = data;
         this.next = next;
     }

     //--- 키값을 반환 ---//
     //K getKey() {
     //    return key;
     //}

     //--- 데이터를 반환 ---//
     V getValue() {
         return data;
     }

     //--- 키의 해시값을 반환 ---//
     public int hashCode() {
         //return key.hashCode();
    	 SimpleObject so = this.getValue();
    	 int number = Interger.parseInt(sno)
     }
 }

 private int    size;              // 해시 테이블의 크기
 private Node<K,V>[] table;        // 해시 테이블 배열(hash table)

 //--- 생성자(constructor) ---//
 public ChainHash(int capacity) {
     try {
         table = new Node[capacity];
         this.size = capacity;
     } catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
         this.size = 0;
     }
 }

 //--- 해시값을 구함 ---//
 public int hashValue(Object key) {
     return key.hashCode() % size;
 }

 //--- 키값이 key인 요소를 검색(데이터를 반환) ---//
 public V search(SimpleObject so) {
     int hash = hashValue(key);            // 검색할 데이터의 해시값
     Node<K,V> p = table[hash];            // 선택 노드

     while (p != null) {
         if (p.getKey().equals(key))
             return p.getValue();                // 검색 성공
         p = p.next;                             // 다음 노드를 선택
     }
     return null;                                // 검색 실패
 }

 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
 public int add(V data) {

 }

 //--- 키값이 key인 요소를 삭제 ---//
 public int remove(V data) {

 }

 //--- 해시 테이블을 덤프(dump) ---//
 public void dump() {
     for (int i = 0; i < size; i++) {
         Node<K,V> p = table[i];
         System.out.printf("%02d  ", i);
         while (p != null) {
             System.out.printf("→ %s (%s)  ", p.getKey(), p.getValue());
             p = p.next;
         }
         System.out.println();
     }
 }
}