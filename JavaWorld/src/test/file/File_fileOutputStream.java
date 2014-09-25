package test.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author YoungRok
 *	내가 만든 중복파일명 처리 Logic
 */

public class File_fileOutputStream {

	public static void main(String[] args) throws IOException {

		File testfile = null;
		String testpath = "d:\\";
		String title = "test";

		int count = 0;
		testfile = new File(testpath, title + ".txt");
		
		
		while(testfile.exists()){
			
			System.out.println("파일이 존재함");

			title = title + "[" + count + "]";
			testfile = new File(testpath, title + ".txt");
			
			if(testfile.exists()){
				title = new String("test");
			}
			count++;
			
			if(!testfile.exists()){
				break;
			}
		}
		
		FileOutputStream fos = new FileOutputStream(testfile, true);

		for (int i = 0; i < 5; i++) {
			fos.write(i);
		}
		fos.close();

		System.out.println(" 지정한 파일명으로 파일이 생성되었습니다. ");
	}
}
