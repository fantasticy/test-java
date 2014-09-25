package test.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

public class UrlTest_2 {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			
			String userid = "mailadm@demotms8.kpost.com";
			String password = "kpost?!";
			String loginPassword = userid + ":" + password;
			String encoded = Base64.encodeBase64String(loginPassword.getBytes());
			
			URL req = new URL("http://gw.kpost.com/mail/mail/folderAllInfo.do");
			HttpURLConnection con = (HttpURLConnection)req.openConnection();
			con.setRequestProperty("Authorization", "Basic " + encoded);

			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = "";
			while((line = br.readLine()) != null ){
				sb.append(line);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(sb);

	}

}
