<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h2>rangerList.jsp</h2>	
  	<table>
  		<thead>
  			<tr>
  				<th>이름</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${rangers }" var="ranger">
  			<tr>
  				<td>${ranger }</td>
  			</tr>
  			</c:forEach>
  		</tbody>
  	
  	</table>
  	<br>
  	게시판 구분 : ${boardGb }
  	게시판 구분 : ${boardGb2 }
  
  
  
  
</body>
</html>