package kr.co.baseprj.common.utils;

import java.security.MessageDigest;

public class SHAUtils {
	
	public static String encrypt(String str) {
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(str.getBytes("UTF-8"));

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			// 출력
			// System.out.println(hexString.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hexString.toString();
		
	}
	
	public static String enc2(String str) {
		String sha = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			sha = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sha;
	}
	
	public static String stringToHex(String s) {
	    String result = "";

	    for (int i = 0; i < s.length(); i++) {
	      result += String.format("%02X", (int) s.charAt(i));
	    }

	    return result;
	  }


	
	public static void main(String args[]) {
		System.out.println(">>>>>>>>>>>>>>>>>> : " +  encrypt("1233").toUpperCase());
//		System.out.println(">>>>>>>>>>>>>>>>>> : " +  stringToHex(encrypt("1233").toUpperCase()));
		System.out.println("################## : " +  enc2("1233").toUpperCase());
//		System.out.println("################## : " +  stringToHex(encrypt("11").toUpperCase()));
		
//		System.out.println("@@@@@@@@@@@@@@@@@@@@ : " +  encrypt("abcD1234!@#$"));
//		System.out.println("@@@@@@@@@@@@@@@@@@@@ : " +  stringToHex(encrypt("abcD1234!@#$")));
	}
}
