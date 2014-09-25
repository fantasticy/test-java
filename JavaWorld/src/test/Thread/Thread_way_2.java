package test.Thread;

/**
 * @author YoungRok
 *
 *	[ Thread 기능을 사용하는 두번째 방법 ]
 *
 * 1. thread 기능을 구현할 클래스에서 Thread 클래스를 상속한뒤 run( ) 메서드를 재정의 해준뒤
 * 2. Thread 클래스를 상속한 클래스를 생성한뒤 바로 start( ) 메서드 호출.
 * 
 * 첫번째 방법(Thread_way_1.class) 보단 지금 이 방법을 권합니다.
 */
public class Thread_way_2 {
	
	public static void main(String[] args) {
		
		System.out.println(" Program Strart !!! ");

		DerivedThread thread = new DerivedThread();
		thread.start();
		
		System.out.println(" Program Finished !!! ");
	}

}

class DerivedThread extends Thread {
	
	@Override
	public void run() {
		
		for( int i = 0 ; i < 50 ; i++ ){
			System.out.print(i + "\t");
		}
	}
}
