package test.file;

import java.io.File;
import java.io.IOException;

public class GetFilePath {
	
	public static void main(String[] args) throws IOException {
		
		File f1 = new File(".");
		File f2 = new File("..");
		
		System.out.println();
		System.out.println(f1.getAbsolutePath());
		System.out.println();
		System.out.println(f2.getAbsolutePath());
		
		System.out.println();
		System.out.println(f1.getCanonicalPath());
		System.out.println();
		System.out.println(f2.getCanonicalPath());
		
		File f3 = new File("C:\\");
		File[] fs = f3.listFiles();
		
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i].getName());
		}
	}

}
