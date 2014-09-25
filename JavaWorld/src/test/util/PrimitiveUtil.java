package test.util;

/**
 * 원시 데이터 형에 관련된 util을 제공합니다.
 * @author s
 *
 */
public class PrimitiveUtil {

	public static long parseLong(Object obj) {
		if (obj == null) return new Long(0);
		
		Long value = new Long(0);
		
		try {
			if (obj instanceof String) {
				value = Long.parseLong(String.valueOf(obj));
			} else {
				value = (Long) obj;
			}
		} catch (Exception e) { 
			// e.printStackTrace();
		}
		
		return value;
		
	}
	
	public static boolean parseBoolean(Object obj) {
		if (obj == null) return false;
		
		Boolean value = new Boolean(false);
		
		try {
			if (obj instanceof String) {
				value = Boolean.parseBoolean(String.valueOf(obj));
			} else {
				value = (Boolean) obj;
			}
		} catch (Exception e) { 
			// e.printStackTrace();
		}
		
		return value;
	}
}
