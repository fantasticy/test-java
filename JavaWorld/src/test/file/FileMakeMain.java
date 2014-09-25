package test.file;

import java.io.File;

public class FileMakeMain {
	
	public static void main(String[] args) {
		
		File f = new File("d:\\", "newFolder");		// 디렉터리를 삭제할 경우 비어 있어야 한다.
																// 파일 먼저 삭제 해야함.
		if(!f.exists()){
			f.mkdirs();
			System.out.println("newFolder 생성 완료");
		}else{
			f.delete();
			System.out.println("newFolder 삭제 완료");
		}
	}

}
