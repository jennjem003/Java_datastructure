package 자료구조;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ArrarList정렬Merge {
	/*
	static int binSearch(String[] s, int n, String key) {
		//자료구조 책 페이지 115 코드 사용한다.
	}
	*/
	public static void main(String[] args) {
		try {
			Path input1 = Paths.get("list1.txt");
			byte[] bytes1 = Files.readAllBytes(input1);
			
			Path input2 = Paths.get("list2.txt");
			byte[] bytes2 = Files.readAllBytes(input2);

			String[] sarray1 = new String[20];
			String[] sarray2 = new String[20];
			
			String s1 = new String(bytes1);
			String s2 = new String(bytes2);
			
			System.out.println("s = " + s1);
			sarray1 = s1.split(",");
			System.out.println("s = " + s2);
			sarray2 = s2.split(",");
			//sarray2 = s2.split(",");
			
			// file1에서 read하여 list1.add()한다.

			
//			BufferedReader reader = new BufferedReader(
//		            new FileReader("list1.txt")
//		        );
//		 
//		        String str;
//		        while ((str = reader.readLine()) != null) {
//		            System.out.println(str);
//		        }
//		 
//		       list1.add();
//		        
		    
//			public static ArrayList<String> readlists() {
//				try (BufferedReader br = new BufferedReader(new FileReader("list1.txt"));) {
//
//					ArrayList<String> list = new ArrayList<String>();
//
//					String str;
//					while((str = br.readLine()) != null) {
//						System.out.printf(",", str);
//						list.add(str);
//					}				
//					return list;
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				return null;
//			}
			// 배열을 list로 만드는 방법
			// 방법1:
//			ArrayList<String> arrayList = new ArrayList<>();
//			for (String temp : sarray1) {
//				arrayList.add(temp);
//			}
			// 방법2
			ArrayList<String> list1 = new ArrayList<>(Arrays.asList(sarray1));

			ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(sarray2));
			// file2에서 read하여 list1.add()한다.

			//
			System.out.println("collection.sort()::");
			Collections.sort(list1);
			System.out.println("list1::");
			for (String city : list1)
				System.out.print(city + " ");
			System.out.println();
			System.out.println("list2::");
			Collections.sort(list2);
			for (String city : list2)
				System.out.print(city + " ");
			ArrayList<String> list3 = new ArrayList<String>();

			Iterator<String> iter1 = list1.iterator();
			Iterator<String> iter2 = list2.iterator();

			//
			// iterator를 사용하여 merge한다
			String data1 = iter1.next();
			String data2 = iter2.next();
			
			while (iter1.hasNext()&& iter2.hasNext()) {
				if(data1.compareTo(data2)<0) {
					list3.add(data1);
					data1= iter1.next();
				} else if(data1.compareTo(data2)>0){
					
				}else {
					list3.add(data1);
					list3.add(data2);
					data1= iter1.next();
					data2= iter1.next();
				}
			}
			
			
			while (iter1.hasNext()){
				if(iter1 == iter2) {

				}
			}
			while (iter2.hasNext()){
				if(iter2 == iter1) {
					
				}
			}
			
			//ArrayList를 merge하는 코드 구현 list3 = list1 + list2(merge)

			// binary search 구현
			// 방법1:
			Arrays.binarySearch(null, null, null);// ArrayList에는 binarySearch()가 없다.
			// 방법2:
			// int result = Collections.binarySearch(list3, newFruit, cc);

			// 방법3:

			System.out.println();
			System.out.println("merge:: ");
			for (String city : list3)
				System.out.print(city + " ");
			// ArrayList를 배열로 전환
			String[] st = list3.toArray(new String[list3.size()]);
			// binary search 구현
			// binSearch(st, st.length, "key");
			// 정렬된 list3을 file에 출력하는 코드 완성
			int bufferSize = 10240;
			String b = " ";
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			for (String sx : list3) {
				System.out.println(" " + sx);
				buffer.put(sx.getBytes());
				buffer.put(b.getBytes());
			}
			buffer.flip();
			FileOutputStream file = new FileOutputStream("c.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
			file.close();
						} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

