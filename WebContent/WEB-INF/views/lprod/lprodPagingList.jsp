<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
				<h1 class="page-header">제품 리스트</h1>
				<!-- userList 정보를 화면에 출력하는 로직 작성 -->
				<div class="table-responsive">
				
				
				
				
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Lprod_id</th>
								<th>Lprod_gu</th>
								<th>Lprod_nm</th>
							</tr>
						</thead>




						<tbody>
							<c:forEach items="${lprodList}" var="lprodlist">
							<tr class="userTr" data-userid="${lprodlist.lprod_gu  }">
								<td></td>
								<td>${lprodlist.lprod_id }</td>
								<td>${lprodlist.lprod_gu }</td>
								<td>${lprodlist.lprod_nm }</td>
								<td></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>

					
					<c:set var="lastPage" value="${Integer(Math.ceil(lprodCnt / pageSize))}" />



				<style>
				
				.disabled{pointer-events:none;}
				.userTr:hover{
				background-color: gray!important;
				}
				</style>



					<nav style="text-align: center;">
						<ul class="pagination">

							<li
								<c:if test="${page=='1'}">
							
							class="disabled"
							</c:if>><a
								href="${pageContext.servletContext.contextPath}/lprod/lprodpagingList"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>

							</a></li>



							<c:forEach var="i" begin="1" end="${lastPage }">
								<li
									<c:if test="${i == page}">
									class="active"
								</c:if>><a
									href="${pageContext.servletContext.contextPath}/lprod/lprodpagingList?page=${i}">${i}</a></li>
							</c:forEach>


							<li
								<c:if test="${page==lastPage}">
									class="disabled"
								</c:if>><a
								href="${pageContext.servletContext.contextPath}/lprod/lprodpagingList?page=${lastPage}"
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

			//사용자 tr 태그 클릭시 이벤트 핸들러
			$(".userTr").click(function() {

				//$(this).children()[1].innerText

				console.log("data-userid :" + $(this).data("userid"));

				var userId = $(this).data("userid");

				//1 document

				//document.location = "/user?userId=" + userId;

				//2 form
				$("#lprod").val(userId);
				$("#frm").submit();

			});

		});
	</script>



	<form id="frm" action="${cp }/lprod/lprod"
		method="get">
		<input type="hidden" id="lprod" name="lprod" />
	</form>

</body>
</html>

