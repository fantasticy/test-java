package test.string;

public class StringTest_01 {
	
	public static void main(String[] args) {
		
		
		String[] codes = new String[] {"김춘삼" , "빌게이츠" , "후진타오" , "박근혜" };
		
		for ( int i=0 ; i <= codes.length ; i++) {
			String a = codes[i].toString();
			
			System.out.println( a );
		}
		
	}


}
