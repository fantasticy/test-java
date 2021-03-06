package test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileMain {

	public static void main(String[] args) throws IOException {

		File f = new File("D:\\", "FileMain2.txt");
		File f2 = new File("D:\\workspace\\JavaWorld\\src\\test\\file\\FileMain.java");
		
		if(!f.exists()){
			f.createNewFile();
		}
		
		FileInputStream fis = new FileInputStream(f2);
		FileOutputStream fos = new FileOutputStream(f);
		
		byte[] b = new byte[10];
		int size = 10;
		int oNum = 0;
		int count;
		
		while((count = fis.read(b, oNum, size)) != -1 ){
			
			System.out.println(" b.length ? " + b.length);
			System.out.println(" b.toString ? " + b.toString());

			for (int i=0 ; i<count; i++){
				fos.write(b[i]);	
			}
		}
		
//		10바이트씩 읽어서 출력하기 b = 10;
//		while((count = fis.read(b)) != -1 ){
//			
//			System.out.println(" conunt ? " + count );
//			
//			fos.write(b);
//			
//		}
		fos.write(b);
		
		fos.close();
		fis.close();

		PrintStream out = System.out;
		
		out.println("isFile(): " + f.isFile()); // 파일인지 아닌지
		out.println("isDirectory(): " + f.isDirectory()); // 디렉터리인지 아닌지
		out.println("isHidden(): " + f.isHidden()); // 숨김파일인지
		out.println("lastModified(): " + f.lastModified()); // 마지막에 수정된 날짜
		out.println("canRead(): " + f.canRead()); // 읽기 속성을 가진 파일인지
		out.println("canWrite(): " + f.canWrite()); // 쓰기 속성을 가진 파일인지
		out.println("getPath(): " + f.getPath()); // 상대 경로
		out.println("getAbsolutePath(): " + f.getAbsolutePath()); // 절대 경로
		out.println("getName(): " + f.getName()); // 디렉터리 또는 파일의 이름
		out.println("toURL(): " + f.toURL()); // URL형식의 경로
		out.println("exists(): " + f.exists()); // 파일이 존재하는지
		out.println("length(): " + f.length()); // 파일의 길이

	}

}
