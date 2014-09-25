package test.properties;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class PropertiesExample {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Properties props = new Properties();
		
		props.setProperty("이름", "고길동");
		props.setProperty("아이디", "gogildong");
		props.setProperty("이메일", "test@test.com");
		
		Enumeration propNames = props.propertyNames();
		Iterator propIter = (Iterator) props.propertyNames();
		
		while (propIter.hasNext()){
			
			String propName = (String) propIter.next();
			System.out.println(propName);
		}
		
		while (propNames.hasMoreElements()){
			
			String prop_name = (String)propNames.nextElement();
			
			String property = props.getProperty(prop_name);
			
			System.out.println(" Properties 키 : " + prop_name + "\t Properties 값 : " + property );
		}
		
		props.list(System.out);
		
		
	}

}
