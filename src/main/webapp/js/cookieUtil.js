


/*
 *쿠키 이름으로 해당하는 쿠키 값을 조회
 */

 function getCookieValue(cookieName) {

	var cookieValue = "";
	var cookieArray = document.cookie.split("; ");
	for(var i = 0; i < cookieArray.length; i++){
		var cookie = cookieArray[i];
		//cookie.split("=")[0];  //cookieName
		//cookie.split("=")[1];  //cookieValue
		
		if(cookieName == cookie.split("=")[0]){
			cookieValue = cookie.split("=")[1];
			break;
		}
	}
	return cookieValue;

}
 
 	/*
 	 * 쿠키생성
 	 */
 
 function setCookie(cookieName,cookieValue,expires) {
	 //현재 날짜 기준으로 expires 날짜 만큼 cookie 생성
	 //쿠키 생성 방법 : document.cookie = "cookie" 문자열 포멧
	 //cookie 문자열 포멧 : cookieName = cookieValue; path=/; expires=gmtString
	 
	 var today = new Date();
	 today.setDate(today.getDate() + parseInt(expires));
	 
	 document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
	 
	
}
 
 	function deleteCookie(cookieName) {
 		var dt = new Date(); //오늘날짜
 		dt.setDate( dt.getDate()-1  ) //하루 전 날짜
 		
 		document.cookie = cookieName + "=; path=/; expires" + dt.toGMTString();
	}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 