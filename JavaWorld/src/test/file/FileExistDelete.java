package test.file;

import java.io.File;

public class FileExistDelete {
	
	public static void main(String[] args) {
		
//		디렉토리 생성
//		File f = new File("test폴더");
//		
//		if(!f.exists()) f.mkdir();
		
		
		// 디렉토리 삭제 
		File f = new File("test폴더");
		
		if(f.exists()) f.delete();
		
	}

}
