package test.math;

import java.util.ArrayList;
import java.util.List;

public class random_test {

	public static void main(String[] args) {
		
		List<Long> somethingList = new ArrayList<Long>();
		
		for (int i = 0 ; i < 10 ; i++){
			
			long a = (long)(Math.random() * 10);
			
			System.out.println(a);
			
			somethingList.add(a);
		}
		
		System.out.println();
		System.out.println((long)(Math.random() * 10));
		
	}
	
}
