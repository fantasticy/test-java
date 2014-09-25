package test.file;

import java.io.File;

public class FileExist {
	
	public static void main(String[] args) {
		
		File f = new File("a.dat");
		boolean b = f.exists();

		System.out.println(b);
		
	}
	
	

}
