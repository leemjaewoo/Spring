<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  
  <script>
		//문서로딩이 완료된 이후 이벤트 등록
		
		$(document).ready(function() {
			console.log("ajaxView.jsp");
			
			$("#jsonReqBtn").on("click",function(){
				//responseBody();
				requestBody();
			});
			
		
		});
		
		
		function requestBody() {
			var data = {userId : "brown", userNm : "브라운"};
			
			$.ajax({
				url : "${cp}/ajax/requestBody",
				method : "post",
				//data :"userId=brown&userNm=브라운",
				//data :$("#frm").serialize(),
				data : JSON.stringify(data),//data를 json 문자열로 전송한다
				dataType : "json",  //server에게 희망하는 리턴타입을 명시
				contentType : "application/json; charset=utf8", //client 전송하는 데이터 타입
	            success :function(data) {
					console.log("data :" + data);
					//renderTable(data);
				
					$("#jsonRecvTbody").html("<tr><td>" + data.userId + "</td></tr>");
					
					
					/* var html = "";
					for (var i = 0; i < data.length; i++) {
						var ranger = data[i];
						html += "<tr><td>" + ranger + "</td></tr>";
					}
					$("#jsonRecvTbody").html(html); */
				
	            }		
			})
			
		}
		
		
		
		function responseBody() {
			$.ajax({
				url : "${cp}/ajax/responseBody",
				method : "post",
				dataType : "json",  //server에게 희망하는 리턴타입을 명시
	            success :function(data) {
					console.log("data :" + data);
					//renderTable(data);
					
					var html = "";
					for (var i = 0; i < data.length; i++) {
						var ranger = data[i];
						html += "<tr><td>" + ranger + "</td></tr>";
					}
					$("#jsonRecvTbody").html(html);
				
	            }		
			})
			
		}
		
		
		
		
		
		
	</script>






</head>
<body>
	
	<form id="frm">
		<input type="text" name="userId" value="brown"/>
		<input type="text" name="userNm" value="브라운"/>
	</form>



	<h2>ajaxView.jsp</h2>
	<h3>json 수신</h3>
	<div>
		<button id="jsonReqBtn">jsonData요청</button>
		<div id="jsonRecv">
			<table border="1">
				<thead>
					<tr>
						<th>이름</th>
					</tr>
				</thead>
				<tbody id="jsonRecvTbody">
				</tbody>
			</table>
		
		
		
		
		</div>
	</div>
</body>
</html>