package test.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_MakeFileByStream {
	
	public static void main(String[] args) throws IOException {
		
		File dir = new File("D:\\", "newFolder");
		
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		System.out.println( dir.getAbsolutePath() );
		System.out.println( dir.getCanonicalPath() );
		System.out.println( dir.getAbsoluteFile() );
		System.out.println( dir.getCanonicalFile() );
		System.out.println( dir.getPath() );
		System.out.println( dir.getParent() );
		System.out.println( dir.getClass());
		System.out.println( dir.isFile());
	
	}

}
