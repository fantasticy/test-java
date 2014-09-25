package test.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File_InputStream {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("a.dat");
		
		int i;

		while( (i=fis.read()) != -1){
			System.out.print((char)i);
		}
		
		fis.close();
	}

}
