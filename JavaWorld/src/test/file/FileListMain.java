package test.file;

import java.io.File;

public class FileListMain {
	
	public static void main(String[] args) {
		
		File f = new File("d:\\");
		File[] fs = f.listFiles();
		
		for (int i = 0; i < fs.length; i++) {
			
			System.out.print(fs[i].getName()+"\t");
			System.out.println(fs[i].isFile());
			
			
		}
		
	}

}
