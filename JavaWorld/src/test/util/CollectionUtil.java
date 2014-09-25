package test.util;

import java.util.List;
import java.util.Set;

public class CollectionUtil {

	 /**
	  * 빈 리스트인 지를 검증합니다.
	  * @param list
	  * @return
	  */
	  public static boolean isEmpty(List<?> list) {
		  if (list == null || list.size() <= 0) {
			  return true;
		  } else {
			  return false;
		  }
	  }
	  
	  public static boolean isEmpty(Set<?> set) {
		  if (set == null || set.size() <= 0) {
			  return true;
		  } else {
			  return false;
		  }
	  }
	  
	  public static int size(List<?> list) {
		  if (list == null) return 0;
		  
		  return list.size();
	  }
}