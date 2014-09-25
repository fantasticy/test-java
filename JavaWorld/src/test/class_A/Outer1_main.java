package test.class_A;

/**
 * @author YoungRok
 */
public class Outer1_main {
	
	public static void main(String[] args) {
		
		Outer1 outer = new Outer1(100, 200);
		
		// 내부 클래스도 외부 클래스의 멤버로 간주되며, 
		// 다른 타입의 필드처럼 동일한 접근성을 가집니다.
		Outer1.Inner inner = outer.getInner();

		System.out.println(" inner 값  : " + inner.total());
	}

}
