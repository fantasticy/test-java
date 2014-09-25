package test.class_A;

public class AnonClass {
	
	public AnonClass() {
		System.out.println();
		System.out.println(" AnonClass 생성 ");
		System.out.println();
	}

	public Object getAnonInnerObj() {
		
		return new Object(){
			public String toString(){
				return "toString 메서드 재정의";
			}
		};
	}
	
}
