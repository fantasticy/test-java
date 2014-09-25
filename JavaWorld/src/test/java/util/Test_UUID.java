package test.java.util;

import java.util.UUID;

public class Test_UUID {
	
	public static void main(String[] args) {
		
		String randomText1 = UUID.randomUUID().toString();
		String randomText2 = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		
		System.out.println(randomText1);
		System.out.println(randomText2);
	}
}
