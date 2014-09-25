package test.util;

public class Validate {

	public static boolean isEmpty(Object obj) {
		boolean empty = false;
		
		if (obj instanceof String) {
			String str = (String) obj;	
			if (str == null || str.trim().length() < 1) empty = true;
		} else {
			if (obj == null)empty = true;
		}
		
		return empty;
	}
	
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}
