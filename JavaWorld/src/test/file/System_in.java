package test.file;

import java.io.IOException;

public class System_in {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("엔터를 누르세요");
		
		int i = System.in.read();
		
		System.out.println(i);
		
	}

}
