package test.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	
	public static void main(String[] args) {
		
		Map <String, Object> modifyMap = new HashMap<String, Object>();

		modifyMap.put("1", "1");
		modifyMap.put("2", "2");
		modifyMap.put("3", "3");
		modifyMap.put("4", "4");
		
		modifyMap.put("1", "10");
		
		Set<Entry<String, Object>> set = modifyMap.entrySet();
		
		for (Iterator i = set.iterator(); i.hasNext();){
			System.out.println(i.next());
		}
	}
	
	

}
