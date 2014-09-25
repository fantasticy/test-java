package test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite {
	
public static void main(String[] args) throws IOException {
		
		// 1. file 사이즈 알아내기
		File f = new File("D:\\workspace\\JavaWorld\\src\\test\\file\\FileMain.java");
		int fileSize = (int)f.length();		
		System.out.println("FileMain.java 의 파일 사이즈 : " + fileSize);
		System.out.println();
		
		// 2. file 사이즈와 같은 크기의 바이트 배열 만들기
		byte[] b = new byte[fileSize];

		// 3. 스트림을 이용해서 배열에 데이터 채우기
		FileInputStream fis = new FileInputStream(f);
		
		System.out.println(" avaliable " + fis.available() );
		
		int pos = 0;	// offset 위치 : 0
		int size = 10;	// 한번에 읽을 byte 수
		int temp;
		int testCount = 1;
		
		while( (size = fis.read(b, pos, size)) > 0 ){
			
			pos += size;								//  offset 자리를 size(10) 만큼 이동 : 읽은 byte 수 : 					
			temp = b.length - pos;					//  남아있는 (읽어야할) 바이트 크기

			
			
			if(temp < 10){						// 읽어야할 바이트가 10보다 작아지면 (1턴)
				size = temp;					// 
			}
		}

		fis.close();
		FileOutputStream fos = new FileOutputStream("test.txt");
		fos.write(b);
		fos.close();
		

	}

}
