package test.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_outputStreamMain {
	
//	write( int b ) 를 이용한 데이터 기록 
//	
//	public static void main(String[] args) throws IOException {
//		
//		FileOutputStream fos = new FileOutputStream("a.dat", true);
//		
//		fos.write(72);
//		fos.write(101);
//		fos.write(108);
//		fos.write(108);
//		fos.write(111);
//
//		fos.close();
//		System.out.println("a.dat 파일 기록  완료");
//	}
	
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("a1.dat");
		
		byte[] b = new byte[]{72, 101, 108, 108, 111};
		
		fos.write(b);
		fos.close();
		System.out.println("a1.dat 파일 기록 완료");
	}

}
