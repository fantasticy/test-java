package test.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil {
	public static String md5String(String inputStr){
		if (inputStr == null) return null;
		MessageDigest clsMd5; 
		
		try {
			clsMd5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) { 
			return null;
		}
		
		
		clsMd5.update(inputStr.getBytes());
		byte[] arrBuf = clsMd5.digest();
		int iLen = arrBuf.length;
		StringBuffer clsBuffer = new StringBuffer();
		if (clsBuffer == null) return null;
		
		for (int i = 0; i < iLen; i++) {
			clsBuffer.append(String.format("%02X", 0xFF & arrBuf[i]));
		}
		
		return clsBuffer.toString();
	}
	
	public static String md5StringLowerCase(String inputStr) {
		return md5String(inputStr).toLowerCase();
	}
	
	
	
	public static String encodeRc4(String str, String rc4Key) {
		if (str == null || str.equals("") || rc4Key == null || rc4Key.equals("")) return "";
		
		String encStr = "";
		
		try {
			byte[] keyBytes = rc4Key.getBytes();
			SecretKeySpec skeySpec = null;
			skeySpec = new SecretKeySpec(keyBytes, "RC4");
			Cipher cipher = Cipher.getInstance("RC4");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] enc = cipher.doFinal(str.getBytes());
			
			encStr = asHex(enc);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return encStr;
	}
	
	public static String decodeRc4(String encStr, String rc4Key) {
		if (encStr == null || encStr.equals("") || rc4Key == null || rc4Key.equals("")) return "";
		
		String str = "";
		
		try {
			byte[] keyBytes = rc4Key.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "RC4");
			Cipher cipher = Cipher.getInstance("RC4");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] original = cipher.doFinal(hexToByteArray(encStr));
			str = new String(original,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}

	
	/**
	 * RC4 decoding to byteArray
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] hexToByteArray(String hex) {
	    if (hex == null || hex.length() == 0) {
	        return null;
	    }

	    byte[] ba = new byte[hex.length() / 2];
	    for (int i = 0; i < ba.length; i++) {
	        ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	    }
	    return ba;
	}
	
	/**
	 * RC4 byteArray to String
	 * 
	 * @param buf
	 * @return
	 */
	public static String asHex(byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		
		
		for (int i = 0; i < buf.length; i++) {
			if ( ((int)buf[i] & 0xff) < 0x10)
				strbuf.append("0");
			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}
		
		return strbuf.toString();
	}
	
	
	public static byte[] getShaHash(byte[] input)  {

			MessageDigest md = null;
			
			try {
				md = MessageDigest.getInstance("SHA1");
			
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			return md.digest(input);

	  }
	  
	public static  String toHexString(byte[] bytes) {
		  
	        if (bytes == null) { return null; }
	 

	 
	        StringBuffer result = new StringBuffer();
	 
	        for (byte b : bytes) {
	 
	            result.append(Integer.toString((b & 0xF0) >> 4, 16));
	 
	            result.append(Integer.toString(b & 0x0F, 16));
	 
	        }
	 
	        return result.toString();
	 
	    }
}
