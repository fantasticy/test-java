package test.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File_InputStreamArray {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\workspace\\JavaWorld\\src\\test\\file\\FileMain.java");
		
		int count;
		byte[] b = new byte[20];
		
		while ( (count = fis.read(b)) != -1){
			
			for(int i=0; i<count; i++){
				
				System.out.print( (char)b[i]);
				System.out.println("\t i ? " + i + "\t conunt ? " + count );

			}
			
		}
		fis.close();
	}

}
