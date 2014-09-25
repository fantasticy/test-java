package test.regex;

import java.util.regex.Pattern;

public class RegexTest1 {
	
	public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";
	
	public static void main(String[] args) {
		
		String str = "가나다라마바사아. 가나다하마바사아.";
		
		System.out.println(str.replaceAll("가나다.", "@"));
		
		String str1 = "전문가가 될건가 말건가";
		
		String str1After = str1.replaceAll("가", "A");
		
		System.out.println(str1After);
		
		//System.out.println(str1.replaceAll("전", "바보"));
		

//	    String str1 = "abc";
//	    String str2 = "aabc";
//	    String str3 = "bcd";
//	    String str4 = "bc";
//	    String str5 = "ab";
//	    String str6 = "ccc bbb ddd aaa";
//	    System.out.println(str1.matches("ab."));
//	    System.out.println(str1.matches("a?bc"));
//	    System.out.println(str2.matches("a?bc"));
//	    System.out.println(str4.matches("a?bc"));
//	    System.out.println(str2.matches("a?b"));
//	    System.out.println(str3.matches("a?b"));
//	    System.out.println(str1.matches("a?c"));
//	    System.out.println(str4.matches("a?c"));
//	    System.out.println(str1.matches("ab?c"));
//	    System.out.println(str5.matches("ab?c"));
//	    System.out.println(str6.matches("^a"));
//	    System.out.println(str2.matches("aa."));
	    
	    Pattern ptt = Pattern.compile("ab.");
	    //System.out.println(ptt.matcher(str2).matches());
	    //System.out.println(ptt.pattern());

	}

	
//		String str = "[test] 동해물과 백두산이 gggg [test] 왜그러세용";
//		String replaceStr = "바보";
//		
//		String regex = "\\[test\\]";
//		
//		str.replaceAll("\\[test\\]", replaceStr);
//		
//		System.out.println(str);
	
//	    System.out.println(EXAMPLE_TEST.matches("\\w.*"));
//	    String[] splitString = (EXAMPLE_TEST.split("\\s+"));
//	    System.out.println(splitString.length); // should be 14
//	    for (String string : splitString) {
//	      System.out.println(string);
//	    }
//	    // replace all whitespace with tabs
//	    System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
//	    System.out.println();
//	    System.out.println();
//	    System.out.println();
}
