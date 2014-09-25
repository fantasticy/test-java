package test.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CurrentDirMain {

	public static void main(String[] args) throws IOException {

		File dir1 = new File(".");
		File dir2 = new File("..");
		File dir3 = new File("d:\\");
		File dir4 = new File("d://");
		File dir5 = new File("d://fileTestDir/");
		File dir6 = new File("C:/Users/*/go/attach/");

		System.out.println();
		System.out.println(" dir1.getAbsolutePath() \t"
				+ dir1.getAbsolutePath());
		System.out.println();
		System.out.println(" dir1.getCanonicalPath() \t"
				+ dir1.getCanonicalPath());
		System.out.println();
		System.out.println(" dir2.getAbsolutePath() \t"
				+ dir2.getAbsolutePath());
		System.out.println();
		System.out.println(" dir2.getCanonicalPath() \t"
				+ dir2.getCanonicalPath());
		System.out.println();
		System.out.println(dir3.getAbsolutePath());
		System.out.println();
		System.out.println(dir4.getAbsolutePath());
		System.out.println();
		System.out.println(dir3.exists());
		System.out.println();
		System.out.println(dir5.exists());
		System.out.println();
		System.out.println(dir5.length());
		System.out.println();
		System.out.println(dir5.getAbsoluteFile().length());
		System.out.println();
		System.out.println(dir5.getCanonicalFile().length()); // Byte 로 반환
		System.out.println();
		System.out.println(System.getenv("OS"));
		System.out.println();
		System.out.println(System.getenv("USERPROFILE"));
		
		if (System.getenv("OS").contains("Windows")){
			System.out.println();
			System.out.println(" windows 임 ");
			System.out.println();
		} else {
			System.out.println();
			System.out.println(" windows 아님 ");
			System.out.println();
		}
		
		File[] filesList = dir5.listFiles();
		
		for (int i = 0 ; i < filesList.length ; i++){
			
			System.out.println(filesList[i].getName());
			System.out.println(filesList[i].length());
			
		}
		
		String osName = System.getProperty("os.name");

		System.out.println();
		System.out.println(" osName ? \t" + osName );
		System.out.println();
		
		
		

//		Map<String, String> envMap = System.getenv();
//		
//		Set<Entry<String, String>> envSet = envMap.entrySet();
//		
//	     for(Iterator i = envSet.iterator(); i.hasNext();){
//             System.out.println(i.next());
//        }
		
		
	}

}
