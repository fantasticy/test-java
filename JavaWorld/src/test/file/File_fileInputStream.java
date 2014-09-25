package test.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File_fileInputStream {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("d:\\d.txt");
		
		int i;
		
		while ((i = fis.read()) != -1){
			System.out.println(i);
		}
		
		System.out.println("지정한 파일로 부터 바이트를 입력받아 화면에 출력하였습니다.");
		fis.close();
		
	}

}
