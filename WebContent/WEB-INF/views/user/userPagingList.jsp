<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">


</head>

<body>


	<%@ include file="/WEB-INF/views/module/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/views/module/menu.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">전체 사용자 리스트</h1>
				<!-- userList 정보를 화면에 출력하는 로직 작성 -->
				<%-- <%=request.getAttribute("list") %> --%>


				<div class="table-responsive">



					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>사용자 아이디</th>
								<th>사용자 이름</th>
								<th>별명</th>
								<th>등록일시</th>
							</tr>
						</thead>

						<tbody>


							<c:forEach items="${userList}" var="userlist">
								<tr class="userTr" data-userid="${userlist.userId }">
									<td></td>
									<td>${userlist.userId }</td>
									<td>${userlist.userNm }</td>
									<td></td>
									<td> <fmt:formatDate value="${userlist.reg_dt }" pattern="yyyy-MM-dd"/> </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					
					
							<form action="${cp }/userForm" method="get">
							<button type="submit" class="btn btn-default">사용자 등록</button>
							</form>



					<c:set var="lastPage" value="${Integer(Math.ceil(userCnt / pageSize))}" />
		
		
		
					<style>
					
					
					
					
.disabled {
	pointer-events: none;
}
</style>



					<nav style="text-align: center;">
						<ul class="pagination">

							<li
								<c:if test="${page=='1'}">
							
							class="disabled"
							</c:if>><a
								href="/user/userPagingList"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>

							</a></li>



							<c:forEach var="i" begin="1" end="${lastPage }">
								<li
									<c:if test="${i == page}">
									class="active"
								</c:if>><a
									href="/user/userPagingList?page=${i}">${i}</a></li>
							</c:forEach>


							<li
								<c:if test="${page==lastPage}">
									class="disabled"
								</c:if>><a
								href="/user/userPagingList?page=${lastPage}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>


						</ul>
					</nav>




				</div>
			</div>

		</div>
	</div>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

	<script>
		//문서로딩이 완료된 이후 이벤트 등록

		$(document).ready(function() {
			console.log("document ready");
			
			
			//server side 에서 비교
			<c:if test="${msg != null}">
			alert("${msg}");
			<%session.removeAttribute("msg");%>
			</c:if>
			

			//사용자 tr 태그 클릭시 이벤트 핸들러
			$(".userTr").click(function() {

				//$(this).children()[1].innerText

				console.log("data-userid :" + $(this).data("userid"));

				var userId = $(this).data("userid");

				//1 document

				//document.location = "/user?userId=" + userId;

				//2 form
				$("#userId").val(userId);
				$("#frm").submit();

			});

		});
	</script>

	<form id="frm" action="${cp }/User" method="get">
		<input type="hidden" id="userId" name="userId" />
	</form>

</body>
</html>

