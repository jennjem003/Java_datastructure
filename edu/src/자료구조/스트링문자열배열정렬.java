package 자료구조;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
//12장 입출력 작업하기 Test06_2를 수정하여 스트링 정렬하기, Test11/596페이지
import java.nio.file.Paths;


public class 스트링문자열배열정렬 {
	   //sa[a] = "Hello"
       //sa[1] = "world" -> 정렬(sort)

public static void main(String[] args) {

try {

	// 파일 읽어스 string 객체를 정렬하는 프로그램 구성
	Path input = Paths.get("abc.txt");
	
	byte[] bytes = Files.readAllBytes(input);
	System.out.println("== readAllBytes ==");
	System.out.println(new String(bytes));
	// ------------------- 추가한 코드
	// file 입출력 + String 처리 + 정렬 코딩
	String s = new String(bytes);
	System.out.println("s = " + s);
	String [] sa = s.split(" |\n");
	//(배열정렬)
	 for(int i = 0; i < sa.length;i++){
		for (int j = 0;j < sa.length; j++) {
			if((sa[i]).compareTo(sa[j])>0){
				String temp = sa[i];
				sa[i]=sa[j];
				sa[j]=temp;
				//반대로 해주어야 한다. 서로 바꿔줘야함
				//전체가 다 돌아야한다.왜?다 비교를 하기 위해.그 순서가 오름차순.
			}
		}
	 }
	 
	// ---------------------------(정렬하고 나서 file에 저장하는것)
	
	int bufferSize = 10240;
	String b = " ";
	ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
	for (String sx : sa) {
		System.out.println(" " + sx);
		buffer.put(sx.getBytes());
		buffer.put(b.getBytes());
	}
	buffer.flip();
	FileOutputStream file = new FileOutputStream("c.txt");
	FileChannel channel = file.getChannel();
	channel.write(buffer);
	file.close();
	
	
	} catch(IOException e) {
			e.printStackTrace();
		}
	}
}



