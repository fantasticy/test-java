package test.string;

import java.util.ArrayList;
import java.util.List;

public class StirngTest_02 {
	
	public static void main(String[] args) {
		
		List<String>list = new ArrayList<String>();
		
		list.add("홍길동");
		list.add("강감찬");
		list.add("유관순");
		list.add("김종서");
		
		for(String out : list){
			
			System.out.println(out);
			
		}
		
	}

}
