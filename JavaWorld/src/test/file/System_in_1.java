package test.file;

import java.io.IOException;

public class System_in_1 {
	
	public static void main(String[] args) throws IOException {
		
		System.out.print("문자를 입력한 후 엔터를 누르세요 ? ");
		
		int i;
		
		while( (i = System.in.read()) != '\n'){
			System.out.println( (char)i + " : " + i );
		}
		
	}

}
