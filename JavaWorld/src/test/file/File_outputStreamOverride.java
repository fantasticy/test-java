package test.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_outputStreamOverride {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("a.dat");
		
		if(f.exists()){
			FileOutputStream fos = new FileOutputStream("a.dat", true);	// 기존 파일이 있다면 내용 추가
			byte[] b = new byte[]{72, 101, 108, 108, 111};					// false : 파일 다시 작성
			
			fos.write(b);
			fos.close();
			
			System.out.println("a.dat 파일의 끝부분에 데이터 추가하기 완료");
		}
	}

}
