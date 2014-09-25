package test.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlTest_1 {
	
	public static void main(String[] args) {
		

		
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			
			URL req = new URL("http://localhost:8000/readQuotaUsage.do?userSeq=29&domainSeq=2");
			HttpURLConnection con = (HttpURLConnection)req.openConnection();
			
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = "";
			while((line = br.readLine()) != null ){
				sb.append(line);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(sb);
	}
	
/*	// added by kPOST YoungRok 2014.02.26_#627 메일 실제 사용량 (로직 변경)
	try {
		URL req = new URL("http://localhost:8000/readQuotaUsage.do?userSeq=" + userSeq + "&domainSeq=" + domainSeq );
		HttpURLConnection con = (HttpURLConnection)req.openConnection();
		Object obj = JSONValue.parse(new InputStreamReader(con.getInputStream()));
		
		JSONObject jObj = (JSONObject) obj;
		String usage = (String) jObj.get("usage");
		userList.get(i).setRealUsedMailVolume(usage);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	// added end !!
*/
}
