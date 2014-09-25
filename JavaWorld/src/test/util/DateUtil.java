package test.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	 
	// 기본 날짜 및 시간 포맷
	public static final String DATE_FORMAT_DEFAULT_VIEW = "yyyy-MM-dd"; // 화면에 보이게 되는 - 구분된 날짜
	public static final String TIME_FORMAT_DEFAULT_VIEW = "HH:mm:ss";	 // 화면에 보이게 되는 : 구분된 시간
	public static final String DATE_FORMAT_DEFAULT_DATA = "yyyyMMdd";   // 데이터 처리용 8자리 날짜
	public static final String TIME_FORMAT_DEFAULT_DATA = "HHmmss";      // 데이터 처리용 8자리 시간
	
	public static String getStringDate(Date date) {
		if (date == null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DEFAULT_VIEW);
		
		return sdf.format(date);
	}
	
	
	
	/**
	 * yyyy-MM-dd HH:mm:ss 형식의 텍스트로 반환합니다.
	 * 
	 * @param cal
	 * @return
	 */
	public static String getFullDateString(Calendar cal) {
		if (cal == null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DEFAULT_VIEW + " " + TIME_FORMAT_DEFAULT_VIEW);
		
		return sdf.format(cal.getTime());
	}
	
	/**
	 * yyyy-MM-dd HH:mm:SS 이나 yyyy-MM-dd, yyyyMMdd 형식으로 입력해주세요.
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date valueOf(String dateStr) {
		if (dateStr == null || dateStr.trim().equals("")) return null;
		
		if (dateStr.length() == 8) {
			dateStr = dateStr.substring(0, 4) + "-" + dateStr.substring(4, 6) + "-" + dateStr.substring(6, 8);
		}
		
		Timestamp timestamp = null;
		java.sql.Date date = null;
		try {
			timestamp = Timestamp.valueOf(dateStr);
		} catch (IllegalArgumentException e) {
			try {
				date = java.sql.Date.valueOf(dateStr);
			} catch (IllegalArgumentException e2) {
				e2.printStackTrace();
			}
			
		}
		
		if (timestamp != null) return timestamp;
		else return date;
	}
	
	/**
	 * 캘린더의 시간을 정시로 수정합니다.
	 * 00시 00분 00초
	 * @param cal
	 */
	public static void setExactlyDate(Calendar cal) {
		if (cal == null) return;
		
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
	}
	
	public static Calendar parseCalendar(String dateStr) {
		if (dateStr == null || dateStr.trim().equals("")) return null;
		
		Date date = valueOf(dateStr);
		
		Calendar cal = null;
		
		if (date != null) {
			cal = Calendar.getInstance();
			cal.setTime(date);
		}
		
		return cal;
	}
	
	/**
	 * 입력 받은 두 날짜를 비교한 결과 값을 반환합니다.
	 * 시간값은 무시하며 단순히 날짜로만 비교합니다.
	 * 
	 * date1 이 클 경우 1
	 * date2 가 클 경우 -1
	 * 같은 경우 0
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare(Date date1, Date date2) {
		if (date1 == null || date2 == null) return 0;
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		
		
		long time1 = cal1.getTimeInMillis() / (60 * 60 * 1000);	// 프로세스가 진행되면서 미세한 시간의 변동이 있을 수 있기 때문에 분단위까지의 시간을 제외시킵니다.
		long time2 = cal2.getTimeInMillis() / (60 * 60 * 1000);
		
		int reInt = 0;
		
		if (time1 > time2) reInt = 1;
		else if (time1 < time2) reInt = -1;
		
	
		return reInt;
	}
	
	/**
	 * 입력받은 문자열이 유효한 날짜형식인지를 검증합니다.
	 * 
	 * @param dateStr
	 * @return
	 */
	public static boolean isDate(String dateStr) {
		if (dateStr == null || dateStr.trim().equals("")) return false;
		Date date = null;
				
		if (dateStr.length() == 8) {
			dateStr = dateStr.substring(0, 4) + "-" + dateStr.substring(4, 6) + "-" + dateStr.substring(6, 8);
		}
		
		try { 
			date = java.sql.Date.valueOf(dateStr);
		} catch (Exception e) {
			
		}
		
		return (date != null) ? true : false;
	}
	
	public static Date add(Date date, int field, int amount) {
		if (date == null) return null;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		
		return cal.getTime();
	}
	
	public static String get(Date date, String pattern) {
		if (date == null || StringUtil.isEmpty(pattern)) return "";
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(date);
	}
	
	/**
	 * 기준일과 비교일 비교하여 차이나는 날짜의 수를 반환합니다.
	 * 비교일이 기준일 이후이면 양수를, 이전이면 음수를 반환합니다.
	 * @param criteria
	 * @param compare
	 * @return
	 */
	public static int getDateGap(long criteria, long compare) {
		if (criteria == 0 || compare == 0) return 0;
		
		long criteriaDate = criteria / 1000 / 60 / 60 / 24;
		long compareDate = compare / 1000 / 60 / 60 / 24;
		
		return (int)(compareDate - criteriaDate);
	}
	
	/**
	 * 오늘(현재)로 부터 비교일을 비교하여 차이나는 날짜의 수를 반환합니다.
	 * 비교일이 오늘 이후이면 양수를, 오늘 이전이면 음수를 반환합니다.
	 * @param compare
	 * @return
	 */
	public static int getDateGapFormToday(long compare) {
		if (compare == 0) return 0;
		
		return getDateGap(new Date().getTime(), compare);
	}
	
}
