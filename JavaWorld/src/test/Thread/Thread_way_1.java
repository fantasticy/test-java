package test.Thread;

/**
 * @author YoungRok
 * 
 * [ Thread 기능을 사용하는 첫번째 방법 ]
 * 
 * 1. 기능이 구현된 클래스에서 java.lang.Runnable Interface 를 상속한뒤 run( ) 메서드를 구현.
 * 2. Runnable 이 구현된 클래스를 진짜 Thread 에 장착.
 * 3. Thread.start( ) 메서드 실행.
 * 
 * 결과적으로 보면 스레드란 main( ) 메서드와 동시에 run( ) 메서드를 동시에 하나 더 실행시키는 기법입니다.
 */
public class Thread_way_1 {
	
	public static void main(String[] args) {
		
		System.out.println("Program Start !!! ");
		
		Top top = new Top();
		
		// Runnable 을 인자로 넘기며 진짜 스레드 만들기
		Thread thread_A = new Thread(top);
		Thread thread_B = new Thread(top);
		thread_A.start();
		thread_B.start();
		
		System.out.println("Program Finished !!! ");
		
	}
	
	

}

// Runnable 인터페이를 구현한 클래스
class Top implements Runnable {
	
	@Override
	public void run() {
		
		for (int i = 1 ; i <= 50 ; i++){
			
			if ( i % 10 == 0 ){
				System.out.println();
			}
			
			System.out.print(i + "\t");
		}
		
	}
}