package kr.or.ddit.util;

public class CookieUtil {
	private String cookieString;
	private String[] cookieArray;

	public CookieUtil(String cookieString) {
		cookieArray = cookieString.split("; ");
		
	}

	
	
	/**
	* Method : getCookieValue
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param cookieName
	* @return
	* Method 설명 : 쿠키이름에 해당하는 쿠키 값을 조회
	*/
	public String getCookieValue(String cookieName) {
//		String[] a = cookieString.split("; ");
//		
//		for (int i = 0; i < a.length; i++) {
//			String[] b = a[i].split("=");
//			if (cookieName.equals(b[0])) {
//				return b[1];
//			}
//		}
//		
//		return null;
		
		String cookieValue = "";
		
		for(String cookie : cookieArray) {
			
			if(cookieName.equals(cookie.split("=")[0])) {
				cookieValue = cookie.split("=")[1];
				break;
			}
			
		}
	return cookieValue;
	
	
	
	
	
	
	}
	

}
