package test.loop;

public class doWhile_test {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 10;
		int c = 20;
		int tmp = 1;
		boolean condition = true;
		
		do {
			
			if(tmp >= 10){
				break;
			}
			System.out.println(" do While test / " + tmp++ );
		} while (condition = true);
		
		
	}

}
