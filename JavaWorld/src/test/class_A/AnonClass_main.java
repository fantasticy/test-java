package test.class_A;

public class AnonClass_main {
	
	public static void main(String[] args) {
		
		AnonClass anonClass = new AnonClass();
		
		Object obj = new Object();
		Object anonObj = anonClass.getAnonInnerObj();
		
		System.out.println(obj.toString());
		System.out.println(anonObj.toString());
	}

}
