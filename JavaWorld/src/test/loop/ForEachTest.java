package test.loop;

import java.util.ArrayList;
import java.util.List;

public class ForEachTest {
	
	
	public static void main(String[] args) {

		List<String> stringList = new ArrayList<String>();

		stringList.add("A");
		stringList.add("B");
		stringList.add("C");
		
		String[] stringArray = new String [3];
		
		stringArray[0] = "D";
		stringArray[1] = "E";
		stringArray[2] = "F";
		
		String[] stringArray2 = { "G", "H", "I" };

		stringArray2[0].replace("0", "NEW");
		
		for (String c : stringArray2){
			
			System.out.println(c);
		}
		System.out.println();
		
		
		for (String a : stringList){
	
			System.out.println(a);
		}
		
		System.out.println();
		
		for (String b : stringArray){

			System.out.println(b);
		}
		
	}
	
}
