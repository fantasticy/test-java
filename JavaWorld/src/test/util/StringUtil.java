package test.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.CharacterIterator;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


public class StringUtil {
	  
	  private static HashMap<String,String> htmlEntities;
	  static {
	    htmlEntities = new HashMap<String,String>();
	    htmlEntities.put("&lt;","<")    ; htmlEntities.put("&gt;",">");
	    htmlEntities.put("&amp;","&")   ; htmlEntities.put("&quot;","\"");
	    htmlEntities.put("&#39;","\'")   ; htmlEntities.put("&#092;","\\");
	    htmlEntities.put("&#123;","{")   ; htmlEntities.put("&#125;","}");
	    htmlEntities.put("&#91;","[")   ; htmlEntities.put("&#093;","]");
	    htmlEntities.put("&#58;",":")   ;
	  }
	  
	  public static final String unescapeHTML(String source) {
	      int i, j;

	      boolean continueLoop;
	      int skip = 0;
	      do {
	         continueLoop = false;
	         i = source.indexOf("&", skip);
	         if (i > -1) {
	           j = source.indexOf(";", i);
	           if (j > i) {
	             String entityToLookFor = source.substring(i, j + 1);
	             String value = (String) htmlEntities.get(entityToLookFor);
	             if (value != null) {
	               source = source.substring(0, i)
	                        + value + source.substring(j + 1);
	               continueLoop = true;
	             }
	             else if (value == null){
	                skip = i+1;
	                continueLoop = true;
	             }
	           }
	         }
	      } while (continueLoop);
	      return source;
	  }

	  
	/**
	 * �� getUserName -> userName
	 * @param setter
	 * @return
	 */
	public static String getterToKey(String getter) {
		if (isEmpty(getter)) return null;
		if (! getter.startsWith("get") ) return null;
		
		String key = "";
		
		key = getter.substring(3);
		String firstStr = key.substring(0, 1);
		key = firstStr.toLowerCase() + key.substring(1);
		
		
		return key;
	}
	
	public static short parseShort(String shortStr) {
		short retInt = 0;
		
		try {
			retInt = Short.parseShort(shortStr);
		} catch(NumberFormatException e) {
			
		}
		
		return retInt;
	}
	
	public static int parseInt(String intStr) {
		int retInt = 0;
		
		try {
			retInt = Integer.parseInt(intStr);
		} catch(NumberFormatException e) {
			
		}
		
		return retInt;
	}
	
	public static Float partFloatReturnNull(String floatStr) {
		float retFloat = 0;
		
		try {
			retFloat = Float.parseFloat(floatStr);
		} catch(NumberFormatException e) {
			return null;
		}
		return retFloat;
	}
	
	public static long parseLong(String longStr) {
		long retLong = 0;
		
		try {
			retLong = Long.parseLong(longStr);
		} catch(NumberFormatException e) {
			
		}
		
		return retLong;
	}
	
	public static Date parseDate(String dateStr) {
		if (isEmpty(dateStr)) return null;
		Date retDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			retDate = sdf.parse(dateStr);
		} catch (ParseException e) {

		}
		
		return retDate;
	}
	
	public static List<Long> parseLong(List<String> longStrs) {
		if (longStrs == null || longStrs.size() == 0) return null;
		
		List<Long> longs = new ArrayList<Long>();
		
		for (String longStr : longStrs) {
			longs.add(parseLong(longStr));
		}
		
		return longs;
	}
	
	
	public static String nullChk(String as_string, String alter) {
		if (as_string == null || "".equals(as_string)
				|| "undefined".equals(as_string)) {
			as_string = alter;
		}
		return as_string;
	}
	
	
	public static String null2blank(String str) {
		return ((str == null) ? "" : str);
	}

	public static String inputStreamToString(InputStream in) throws IOException {
		if (in == null) return null;

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		try {
			return readerToString(reader);
		} finally {
			if (in != null) try { in.close(); } catch (Exception localException1) { }
		}
	}

	public static String readerToString(Reader rd) throws IOException {
		int BUFFER_LENGTH = 1024;
		
		if (rd == null) return null;
  
		StringBuffer resultSb = new StringBuffer();

		try {
			char[] buf = new char[1024];
			int readcnt = 0;

			while ((readcnt = rd.read(buf, 0, 1024)) != -1) {
				resultSb.append(buf, 0, readcnt);
				if (readcnt < 1024);
			}
		} finally {
			if (rd != null) try { rd.close(); } catch (Exception localException) { }
		}

		return resultSb.toString();
	}

	public static String toCamel(String columnName) {
		if (columnName == null) return null;
		if (columnName.equals(columnName.toUpperCase())) columnName = columnName.toLowerCase();

		StringTokenizer tokenizer = new StringTokenizer(columnName, "_");
		StringBuffer result = new StringBuffer();
		while (tokenizer.hasMoreTokens()) {
			result.append(toHeadUpperCase(tokenizer.nextToken()));
		}

		return result.toString();
	}

	public static String toHeadUpperCase(String str) {
		if (isEmpty(str)) return str;
     
		return Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length());
	}
	
	public static boolean equals(String str1, String str2) {
		if (str1 == null && str2 == null) return true;
		if (str1 == null ||str2 == null) return false;
		
		boolean isEquals = false;
		

		if (str1.equals(str2))
			isEquals = true;
		
		return isEquals;
	}
	
	public static boolean equalsIgnoreCase(String str1, String str2) {
		if (isEmpty(str1) || isEmpty(str2)) return false;
		
		boolean isEquals = false;
		

		if (str1.equalsIgnoreCase(str2))
			isEquals = true;
		
		return isEquals;
	}
	
	public static boolean equalsI(String str1, String str2) {
		
		return equalsIgnoreCase(str1, str2);
	}
	
 
	public static String toHeadLowerCase(String str) {
		if (isEmpty(str)) return str;
		
		return Character.toLowerCase(str.charAt(0)) + str.substring(1, str.length());
	}

	public static boolean isEmpty(String str) {
		return ((str == null) || (str.trim().equals("")));
	}
	
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	public static boolean isNumber(String str) {
		if (isEmpty(str)) return false;
		
		str = str.trim(); 
		boolean bool = true;
		
		try {
			Integer.parseInt(str);
		} catch(NumberFormatException e) {
			try {
				Long.parseLong(str);
			} catch(NumberFormatException e2) {
				bool = false;
			}
		}
		
		return bool;
	}
 
	public static String toKorean(String str, String korEncType) {
		if (str == null) return "";
		
		try {
			str = new String(str.getBytes("ISO8859_1"), korEncType);
		} catch (Exception localException) {
		
		}
 
		return str;
	}

	public static String toAscii(String str, String korEncType) {
		if (str == null) return "";
		
		try {
			str = new String(str.getBytes(korEncType), "ISO8859_1");
		} catch (Exception localException) {
    
		}
		return str;
	}
 

	public static String replace(String source, String pattern, String replace) {
		if (isEmpty(source)) return "";
		if (replace == null) replace = "";

		int i = 0;
		int j = 0;
		int k = pattern.length();

		StringBuffer buf = null;
		String result = source;
		while ((j = source.indexOf(pattern, i)) >= 0) {
			if (buf == null) buf = new StringBuffer(source.length() * 2);
			buf.append(source.substring(i, j));
			buf.append(replace);

			i = j + k;
		}
 
		if (i != 0) {
			buf.append(source.substring(i));
			result = buf.toString();
		}
		
		return result;
	}
 
	public static ArrayList toArrayList(String srcTxt, String delim) {
		ArrayList list = new ArrayList();
		if (isEmpty(srcTxt)) return list;
 
		StringTokenizer st = new StringTokenizer(srcTxt, delim);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		
		return list;
	}
 

	public static String cutStr(String str, int length, String tail) {
		return cutStr(str, length, '+', tail);
	}

	public static String cutStr(String str, int length, char type, String tail) {
		
		String hanChar ="가";
		byte[] hanBytes = hanChar.getBytes();
		int hanLength = hanBytes.length;
		
		
		byte[] bytes = str.getBytes();
		int counter = 0;
		if (length >= bytes.length) return str;
		
		for (int i = length - 1; i >= 0; --i) {
			if ((bytes[i] & 0x80) == 0) continue; 
			
			++counter;
		}
		
		String f_str = null;
		
		System.out.println("counter : " + counter);
		
		if (hanLength == 3) {
			// UTF8은 한글자에 3자리이기 때문에 누락된 길이 만큼 보정해 줍니다.
			int correct = (counter / 3);
			//System.out.println("correct 1 : " + correct);
			correct += (correct % 3 == 0) ? 0 : 3 - (correct % 3);
			//System.out.println("correct 2 : " + correct);
			//length += correct;
			//System.out.println("afer length : " + length);
			/*
			switch (type) {
			
				case ',':
				case '-':
				default:
					f_str = new String(bytes, 0, length - (3 - (counter % 3)) );
				break;
				case '+':
					f_str = new String(bytes, 0, length + (3 - (counter % 3)) );
			}
			*/
			f_str = new String(bytes, 0, length - (3 - (counter % 3)) );
			
		} else {
			switch (type) {
			case ',':
			case '-':
			default:
				f_str = new String(bytes, 0, length - (counter % 2));
			break;
			case '+':
				f_str = new String(bytes, 0, length + (counter % 2) );
			}	
		}

		return f_str + tail;
	}

	public static int splitPointInLimit(String text, int limit) {
		int splitPoint = 0;

		char[] delim = { ' ', '\n' };

		String tmpCurrTxt = text.substring(0, limit);

		for (int i = 0; i < delim.length; ++i) {
			int tmpPoint = tmpCurrTxt.lastIndexOf(delim[i]);
			if ((splitPoint != 0) && (splitPoint >= tmpPoint)) continue; splitPoint = tmpPoint;
		}
 
		return splitPoint;
	}

	public static String[] split(String srcTxt, int limit) {
		ArrayList txtList = new ArrayList();

		String tmpTxt = srcTxt;
		
		while (tmpTxt.length() > limit) {
			int splitPoint = splitPointInLimit(tmpTxt, limit);
			txtList.add(tmpTxt.substring(0, splitPoint));

			tmpTxt = tmpTxt.substring(splitPoint);
		}
		
		txtList.add(tmpTxt);

		String[] arr = new String[txtList.size()];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = ((String)txtList.get(i));
		}
		return arr;
	}
	
	public static List<String> split(String str, String delim) {
		List<String> splitedStrs = new ArrayList<String>();
		
		if (str != null && delim != null) {
			String[] strArr = str.split(delim);
			splitedStrs = new ArrayList<String>(Arrays.asList(strArr));
		}
		
		return splitedStrs;
	}

	public static boolean writeFileFromString(String text, String savePath, String saveFileName, String charSetName, boolean bom) throws IOException {
		boolean result = false;
 
		if (text == null) text = "";

		FileUtil.makeDir(savePath);
 
		File file = new File(savePath + "/" + saveFileName);
 
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
     
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos, charSetName);
			bw = new BufferedWriter(osw);
 
			charSetName = charSetName.toLowerCase();
			if ((((charSetName.equals("utf-8")) || (charSetName.equals("utf8")) || (charSetName.startsWith("utf-16")) || (charSetName.startsWith("utf16")))) && (bom)) osw.write(65279);
			bw.write(text);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			if (bw != null) bw.close();
			if (osw != null) osw.close();
				if (fos != null) fos.close();
		}
 
		return result;
	}
	
	public static String encodeForAjax(String str, String encode) {
		if (isEmpty(str) || isEmpty(encode)) return "";

		try {
			return URLEncoder.encode(str, encode).replace("+", " ").replace("%3A", ":").replace("%2F", "/").replace("%3F", "?").replace("%3D", "=").replace("%40", "@").replace("%2C", ",").replace("%07", "");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
		
	}
	
	public static String encode(String str, String encode) {
		if (isEmpty(str) || isEmpty(encode)) return "";

		try {
			return URLEncoder.encode(str, encode);
		} catch (UnsupportedEncodingException e) {
			return str;
		}
		
	}
	
	public static String decode(String str, String encode) {
		if (isEmpty(str) || isEmpty(encode)) return "";

		try {
			
			return URLDecoder.decode(str, encode);
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}
	
	public static boolean isEngAndNum(String str) {
		if (isEmpty(str)) return false;
		

		return true;
	}
	

	
	public static boolean isBetween(String str, int min, int max) {
		if (isEmpty(str)) return false;
		if (min < 0 || max < 0) return false;
		if (min > max) return false;
		
		
		if (str.length() >= min && str.length() <= max) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String replaceHtml2Text(String oldtext) {

		StringBuffer newtext = new StringBuffer();
		int cnt = 0;

		if(oldtext == null) return null;

		String strTmp = oldtext;
		int idx = (strTmp.toLowerCase()).indexOf("<body");

		if (idx > 0) {
			strTmp = strTmp.substring(idx);
		}

		strTmp = strTmp.replaceAll("<BR>", "\n");
		strTmp = strTmp.replaceAll("<br>", "\n");
		strTmp = strTmp.replaceAll("<br/>", "\n");
		strTmp = strTmp.replaceAll("<br />", "\n");
		strTmp = strTmp.replaceAll("&nbsp;", " ");
		strTmp = strTmp.replaceAll("&lt;", "<");
		strTmp = strTmp.replaceAll("&gt;", ">");

		StringTokenizer st = new StringTokenizer(strTmp, ">");

		while(st.hasMoreElements()) {
			String strElem = (String)st.nextElement();
			int lastIndex = strElem.indexOf("<");

			if(lastIndex <= 0) continue;

			newtext.append(strElem.substring(0, lastIndex));

			if (cnt > 1000) break;
			cnt++;
		}

		newtext.append("\n");

		return newtext.toString();
	}
	
	public static String replaceText2Html(String oldtext) {
		 if (oldtext == null) return "";
		 
			String newtext	= oldtext.replaceAll("<", "&lt;");
			newtext = newtext.replaceAll("\r\n", "<br />");
			newtext = newtext.replaceAll("\n", "<br />");
			
			StringBuffer buff = new StringBuffer();
			boolean innerTagCharacter = false;
			for (int i = 0; i < newtext.length(); i++) {
				char c = newtext.charAt(i);
				if (c == '<') {
					innerTagCharacter = true;
				} else if (innerTagCharacter && c == '>') {
					innerTagCharacter = false;
				}
				
				if (!innerTagCharacter && c == ' ') {
					buff.append("&nbsp;");
				} else {
					buff.append(c);
				}
			}
			
			return replaceLink(buff.toString());
	}
	 
	 public static String replaceLink(String text) {
		 if (text == null) return "";
		 
	        String worktext = text;
	        StringBuffer sb = new StringBuffer();
	        int start = 0;
	        int end = 0;

	        while ((end = worktext.indexOf("http", start)) != -1) {
				int endpos = getEndPosition(worktext, end+1);
				String newstr = "";

				if(endpos > end) {
					newstr = text.substring(end, endpos).trim();

					boolean isLink = newstr.matches(
						"((http|ftp|https)://([a-zA-Z0-9]|-|[_,.@/\\~:?%%=&])+)");

					if(isLink) {
						newstr = "<a href=\""+newstr+"\" target=_blank>"+newstr+"</a>";
					}

	            	sb.append(text.substring(start, end) + newstr);
	            	start = end + (endpos - end);
				}
				else {
					break;
				}
	        }

	        sb.append(text.substring(start));

	        return sb.toString();
	   }
	 
	 public static int getEndPosition(String text, int start) {
			int endpos1 = text.indexOf("\n", start);
			int endpos2 = text.indexOf("\t", start);
			int endpos3 = text.indexOf(" ", start);
			int endpos4 = text.indexOf("<br>", start);

			int endpos = text.length();

			endpos = Math.min(
				(endpos1 < 0) ? endpos : endpos1,
				(endpos2 < 0) ? endpos : endpos2);
			endpos = Math.min(endpos, (endpos3 < 0) ? endpos : endpos3);
			endpos = Math.min(endpos, (endpos4 < 0) ? endpos : endpos4);

			return endpos;
		}
	 
	 public static boolean convYNtoBoolean(String str) {
		 if (str == null) return false;
		 
		 return "Y".equalsIgnoreCase(str) ? true : false;
	 }
	 
	 public static Map<String, String> convertSerialToMap(String serialStr, String itemDelim, String delim) {
		if (isEmpty(serialStr) || isEmpty(itemDelim) || isEmpty(delim)) return null;
		
		Map<String, String> map = new HashMap<String, String>();
		String[] items = serialStr.split(itemDelim);
		
		for (int i = 0; i < items.length; i++) {
			if (items[i].split(delim).length < 1) continue;
		
			map.put(items[i].split(delim)[0].trim(), items[i].split(delim).length > 1 ? items[i].split(delim)[1].trim() : "");
		}
		
		return map;
	 }
	 
	 public static String convertListToSerial(List list, String delim) {
		 StringBuilder serialSb = new StringBuilder();
		 
		 if (list != null) {
			 for (Object obj : list) {
				 if (serialSb.length() > 0) serialSb.append(delim);
				 serialSb.append(obj.toString());
			 }
		 }
		 
		 return serialSb.toString();
	 }

	public static String EscapeHTMLTag(String aTagFragment) {
		StringBuffer result = new StringBuffer();
		
		if(aTagFragment != null){
			StringCharacterIterator iterator = new StringCharacterIterator(aTagFragment);
			char character =  iterator.current();
			while (character != CharacterIterator.DONE ){
				
				switch (character) {
					case '<':
					result.append("&lt;");
					    break;
					
					case '>':
					result.append("&gt;");
					    break;
					
					case '&':                
					result.append("&amp;");
					    break;
					
					case '"':
					result.append("&quot;");
					    break;
					
					case '\'':                
					result.append("&#39;");
					    break;
					    
					case '\\':                
					result.append("&#092;");
					    break;
					    
					case '{':                
						result.append("&#123;");
					    break;
					    
					case '}':                
						result.append("&#125;");
					    break;
					    
					case '[':                
						result.append("&#91;");
					    break;
					    
					case ']':                
						result.append("&#93;");
					    break;
					    
					case ':':                
						result.append("&#58;");
					    break;
					    
					default :
						result.append(character);
						break;
						
				}
				character = iterator.next();
			}
		}
		return getCRLFEscape(result.toString());
	}


	
	public static String getCRLFEscape(String str){
		StringBuffer result = new StringBuffer();
		
		if(str != null){
			StringCharacterIterator iterator = new StringCharacterIterator(str);
			char character =  iterator.current();
			while (character != CharacterIterator.DONE ){
				if(Character.getType(character) != 15){
					
					if(Character.getType(character) == 28){
						result.append(" ");
					} else {
						switch (character) {
						case '\n':
						result.append("\n");
						    break;
						
						case '\t':
						result.append(" ");
						    break;
						
						case '\r':                
						result.append(" ");
						    break;
						    
						default :
							result.append(character);
							break;
							
						}
					}
				} else {
					if(character == '\n' || character == '\r'){
						result.append("\n");
					} else {
						result.append(" ");
					}
				}
				character = iterator.next();
			}
		}
		return result.toString();
	}	
	
	public static String convertBytesUnit(long bytes, char unitInital) {
		
		if (unitInital == 'k' || unitInital == 'K') {
			double b = (double) (bytes / 1024);
			b = (double) ( (long) (b * 10) / 10);
			
			String unit = unitInital == 'k' ? "kb" : "KB";
			return b + unit;
		} else if (unitInital == 'm' || unitInital == 'M') {
			double b = (double) (bytes / (1024 * 1024));
			b = (double) ( (long) (b * 10) / 10);
			
			String unit = unitInital == 'm' ? "mb" : "MB";
			return b + unit;
		} else if (unitInital == 'g' || unitInital == 'G') {
			double b = (double) (bytes / (1024 * 1024 * 1024));
			b = (double) ( (long) (b * 10) / 10);
			
			String unit = unitInital == 'g' ? "gb" : "GB";
			return b + unit;
		}
		
		return String.valueOf(bytes);
	}
	
	public static String convertBytesToUnit(long bytes) {
		String unitedBytes = "0";
		DecimalFormat df = new DecimalFormat("###,###.#");
		
		if (bytes <= 1024) {
			unitedBytes = df.format(bytes) + "Byte";
		} else if (bytes <= 1024 * 1024) {
			double d = ( (double) bytes / 1024);
			unitedBytes = df.format(d) + "KB";
		} else if (bytes <= 1024 * 1024 * 1024) {
			double d =  ( (double) bytes / (1024 * 1024));
			unitedBytes = df.format(d) + "MB";
		} else if (bytes <= 1024 * 1024 * 1024 * 1024) {
			double d = ( (double) bytes / (1024 * 1024 * 1024));
			unitedBytes = df.format(d) + "GB";
		} else if (bytes <= 1024 * 1024 * 1024 * 1024 * 1024) {
			double d = ( (double) bytes / (1024 * 1024 * 1024 * 1024));
			unitedBytes = df.format(d) + "TB";
		}
		
		return unitedBytes;
	}
	
	/**
	 * 단위가 있는 바이트 표시를 원시 바이트형태로 변환하여 반환합니다.
	 * 
	 * @param unitByte
	 * @return
	 */
	public static long convertUnitToOrigByte(String unitByte) {
		if (isEmpty(unitByte)) return 0;
		
		unitByte = unitByte.toUpperCase();
		
		// , 제거
		unitByte = unitByte.replace(",", "");
		
		String regx = "^\\p{Digit}+(K|KB|M|MB|G|GB)?$";
		
		if (!unitByte.matches(regx)) return 0;
		
		long origByte = parseLong(strainNumber(unitByte));
		if (unitByte.endsWith("K") || unitByte.endsWith("KB")) {
			origByte = origByte * 1024;
		} else if (unitByte.endsWith("M") || unitByte.endsWith("MB")) {
			origByte = origByte * 1024 * 1024;
		} else if (unitByte.endsWith("G") || unitByte.endsWith("GB")) {
			origByte = origByte * 1024 * 1024 * 1024;
		}
	
		return origByte;
	}
	
	public static String getExtension(String fileName) {
		if (isEmpty(fileName)) return "";
		
		if (fileName.indexOf('.')  == -1) return "";
		return fileName.substring(fileName.lastIndexOf('.') + 1);
	}
	
	public static String getURLEncFileName(String str, int len)
		throws UnsupportedEncodingException {

		String strExt 	= "";
		String strName 	= "";
		String strFileName = "";
		int start = 0;

		if(str == null) {
			return "";
		}

		String fileName = str.replaceAll("\\\\", "");		
				
		fileName = fileName.replaceAll("[\t\n\r]", " ");		
		fileName = fileName.replaceAll("[/:*?\"<>|]", "_");
		fileName = fileName.replaceAll(" ", "_");
		
		
		fileName = UTF8URLEncode(fileName);
		

		if(fileName.length() < len) {			
			return fileName;
		}

		start = str.lastIndexOf('.');

		if(start > 0) {
			strExt = str.substring(start);
			strName = str.substring(0, start);
		} else {
			strName = str;
		}

		while((fileName.length() >= len)) {
			strName = strName.substring(0, (strName.length() - 2));
			fileName = strName + "~" + strExt;
			fileName = fileName.replaceAll("\\\\", "");		
			fileName = fileName.replaceAll("[\t\n\r]", " ");		
			fileName = fileName.replaceAll("[/:*?\"<>|]", "_");
			fileName = fileName.replaceAll(" ", "_");
			fileName = UTF8URLEncode(fileName);
			
		}
		
		return fileName;
	}	
	
	public static String UTF8URLEncode(String str) {
		if (str == null) return null;

		String strTmp = str.trim();

		try {
			strTmp = URLEncoder.encode(strTmp, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			System.out.println("-- UTF8URLEncode Error ["+str+"] ["+e.getMessage()+"]");
		}
		return strTmp;
	}
	
	/**
	 * 문자열을 일부 혹은 전부를 보이지 않도록 처리합니다.
	 * 
	 * @param plainLength 가리지 않을 문자열 길이 (처음부터). 0이면 모두 가림처리 합니다. 
	 * @param hideChar 문자를 가릴때 사용할 문자. 기본 *
	 * @return
	 */
	public static String hideString(String str, int plainLength, char hideChar) {
		if (isEmpty(str)) return str;
		if (hideChar == ' ') hideChar = '*';
		if (plainLength < 0) plainLength = 0;
		
		int strLength = str.length();
		StringBuffer reStr = new StringBuffer();
		
		// 가리지 않을 문자열의 길이가 입력된 문자열의 길이보다 크거나 같으면 문자열 그대로 반환합니다.
		if (plainLength >= strLength) return str;
		
		reStr.append(str.substring(0, plainLength));
		
		for (int i = plainLength; i < strLength; i++) {
			reStr.append(hideChar);
		}
		
		return reStr.toString();
	}  
	
	/**
	 * 문자열 중에서 숫자만 걸러서 반환합니다.
	 * @param str
	 * @return
	 */
	public static String strainNumber(String str) {
		if (StringUtil.isEmpty(str)) return "";
		
		final String regx = "\\D";
		str = str.replaceAll(regx, "");
		
		return str;
	}
	
	/**
	 * 입력받은 문자열을 합쳐서 반환합니다.
	 * @param strings
	 * @return
	 */
	public static String conCat(String... strings) {
		if (strings == null || strings.length == 0) return "";
		
		StringBuffer stringSb = new StringBuffer();
		for (String str : strings) {
			if (str != null) stringSb.append(str);
		}
		return stringSb.toString();
	}
	
	public static String substring(String str, int beginIndex, int endIndex) {
		String reStr = "";
		
		try {
			reStr = str.substring(beginIndex, endIndex);
		} catch(Exception e) { 
			
		}
		
		return reStr;
	}
	
	/**
	 * 입력받은 문자열을 입력된 길이까지 특정 단어로 채워서 반환합니다.
	 * 
	 * @param length
	 * @param ch
	 * @return
	 */
	public static String padLeft(String str, int length, char ch) {
		if (isEmpty(str)) return str;
		if (str.length() >= length) return str;
		
		StringBuilder padSb = new StringBuilder();
		int gap = length - str.length();
		
		for (int i = 0 ; i < gap; i++) {
			padSb.append(ch);
		}
		
		return padSb.toString() + str;
	}
	
	public static String toLowerCase(String str) {
		if (isEmpty(str)) return "";
		
		return str.toLowerCase();
	}
	
	/**
	 * 문자열 특정 문자를 기준을 나눈 뒤 지정된 위치의 문자열을 반환합니다.
	 * 
	 * @param str
	 * @param delim	
	 * @param pos	반환할 문자의 위치
	 * @param allowNull 지정된 위치에 반환할 값이 없을 경우 null로 반환할지 여부를 결정합니다. false 일 경우 블랭크 값으로 반환합니다.
	 * @return
	 */
	public  static String split(String str, String delim, int pos, boolean allowNull) {
		if (str == null) {
			if (allowNull) return null;
			else return "";
		}
		if ( isEmpty(delim) ) return str;
		if (pos < 0) return str;
		
		String[] strArr = str.split(delim);
		
		// 지정된 위치가 배열의 길이 보다 크면..
		if ( pos > (strArr.length -1) ) {
			if (allowNull) return null;
			else return "";
		} else {
			return strArr[pos]; 
		}
		
		
	}
	
	/**
	 * 입력받은 맵의 value 중에서 null 값을 blank 값으로 변환합니다.
	 * value 타입이 String 이 아닌 경우 skip 합니다.
	 * @param map
	 * @return
	 */
	public static Map<String, Object> nulltoBlank(Map<String, Object> map) {
		if (map == null) return null;
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			if (map.get(key) instanceof String) {
				if (map.get(key) == null) map.put(key, "");
			}
			if (map.get(key) == null) { try { map.put(key, ""); } catch (Exception e) {} }  // cast 오류가 발생할 가능성이 있어 예외 처리함. 
		}
		
		return map;
	}
	
	/**
	 * 입력 받은 문자열이 후보 문자열에 포함되어 있는지를 검증 합니다.
	 * @param candidate
	 * @param str
	 * @return
	 */
	public static boolean contain(String[] candidates, String str) {
		if (candidates == null || candidates.length == 0) return false;
		if (isEmpty(str)) return false;
		
		boolean contain = false;
		
		for (String candidate : candidates) {
			if (isEmpty(candidate)) continue;
			
			if (candidate.equals(str)) {
				contain = true;
				break;
			}
		}
		
		return contain;
	}
	
	public static boolean contain(List<String> cadidates, String str) {
		if (cadidates == null || cadidates.size() == 0) return false;
		
		String[] cadidateArr =  cadidates.toArray(new String[0]);
		
		return contain(cadidateArr, str);
 	}
	
	
	public static boolean contain(short[] candidates, String str) {
		if (candidates == null || candidates.length == 0) return false;
		if (isEmpty(str)) return false;
		
		boolean contain = false;
		
		for (short candidate : candidates) {
			
			if (String.valueOf(candidate).equals(str)) {
				contain = true;
				break;
			}
		}
		
		return contain;
	}
	
	
	public static boolean containI(String[] candidates, String str) {
		
		if (candidates != null && candidates.length > 0) {
			for (int i = 0; i < candidates.length; i++) {
				candidates[i] = candidates[i].toLowerCase();
			}
		}
		
		if (isNotEmpty(str)) str = str.toLowerCase();
		
		return contain(candidates, str);
	}
	
	public static String trim(String str) {
		if (str == null) return null;
		
		return str.trim();
	}
	
	public static int length(String str) {
		if (str == null) return 0;
		
		return str.length();
	}
	
	public static String toString(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		
		StringBuilder resultSb = new StringBuilder();
		
		for (int i = 0; i < strs.length; i++) {
			if (i > 0) resultSb.append(",");
			resultSb.append(strs[i]);
		}
		
		return resultSb.toString();
	}
	
	public static boolean checkSerialCharacter(String str, int length) {
		int serialLength = 1;
		
		if (str == null) return false;
		
		char prevChar = (char) -1;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			System.out.println("ch : "+ ch);
			if (i != 0) {
				if (prevChar == ch) serialLength++;
				else serialLength = 1;
			}
			
			prevChar = ch;
		}
		
		System.out.println("serialLength : "+ serialLength);
		if (serialLength >= length) return false;
		else return true;
	}
	
	public static String valueOf(Object obj) {
		if (obj == null) return "";
		
		return String.valueOf(obj);
	}
}