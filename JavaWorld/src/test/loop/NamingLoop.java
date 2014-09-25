package test.loop;

public class NamingLoop {
	
	public static void main(String[] args) {
		
		int x = 0;
		int y = 0;
		int a = 100;
		int b = 100;
		
		
		Loop1 : while(x < a){
			System.out.println("x = " + x++);
			
			while(y < b){
				System.out.println("y =  " + y++);
				if (y == 10){
					break Loop1;
				}
			}
			
			
		}
		
		
	}

}
