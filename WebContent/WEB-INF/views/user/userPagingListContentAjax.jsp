<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1 class="page-header">전체 사용자 리스트(AjaxTiles)</h1>
<!-- userList 정보를 화면에 출력하는 로직 작성 -->

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
		<tbody id="userListTbody">
		</tbody>
	</table>
	<form action="${cp}/user/userForm" method="get">
		<button type="submit" class="btn_btn-default">사용자 등록</button>
	</form>

	<c:set var="lastPage"
		value="${Integer(userCnt / pageSize + (userCnt % pageSize > 0 ? 1 : 0))}" />

	<nav style="text-align: center;">
		<ul id="Pagination" class="pagination">
		

		</ul>
	</nav>


</div>

<script>
	//사용자 배열을 이용하여 사용자 리스트 HTML을 생성
	function makeUserList(userList) {
		var html = "";
		
		for(var i = 0; i < userList.length; i++){
			var user = userList[i];
			html += "<tr class='userTr' data-userid='"+ user.userId+ "'>";
			html += "	<td></td>";
			html += "	<td>"+ user.userId +"</td>";
			html += "	<td>"+ user.userNm +"</td>";
			html += "	<td></td>";
			html += "	<td>"+ user.reg_dt_fmt +"</td>";
			html += "</tr>";
		}
		$("#userListTbody").html(html);
		
	}
	
	function makePagination(userCnt, pageSize, page) {

		var lastPage = parseInt(userCnt/pageSize) + (userCnt%pageSize > 0 ? 1 : 0);
		
		var html = "";
		
		
		if(page == 1){
			html += "<li class='disabled'> ";
			html += "	<a aria-label='Previous'> ";
			html += "		<span aria-hidden='true'>&laquo;</span> ";
			html += "	</a> ";
			html += "</li> ";
		}
		else{
			html += "<li>";
			html += "	<a href='javascript:getUserPageList(1);' aria-label='Previous'>";
			html += "		<span aria-hidden='true'>&laquo;</span>";
			html += "	</a>";
			html += "</li>";
		}
		
		for(var i = 1; i <= lastPage; i++){
			var active = "";
			if(i == page){
				active = "active";
			}
			html += "<li class='"+active +"'>";
			html += "<a href='javascript:getUserPageList("+i+");'>"+i;
			html += "</a>";
			html += "</li>";
			
		}
		
		if(page==lastPage){
	         html += "<li class='disabled'>";
	         html += "   <a aria-label='Next'>";
	         html += "      <span aria-hidden='true'>&raquo;</span>";
	         html += "   </a>";
	         html += "</li>";
	      }else{
	         html += "<li>";
	         html += "   <a href='javascript:getUserPageList("+lastPage+");' aria-label='Next'>";
	         html += "      <span aria-hidden='true'>&raquo;</span>";
	         html += "   </a>";
	         html += "</li>";
	      }
		
	
	$("#Pagination").html(html);
		
	}

	
	
	
	
	
	
	

	function getUserPageList(page) {
		$.ajax({
			url :"${cp}/user/userPagingListAjax",
			data : "page="+page,
			success : function(data){
				makeUserList(data.userList);
				makePagination(data.userCnt, data.pageSize, data.page);
				
				
				
			}
		});
		
	}
	
	function getUserPageListHtml(page) {
		$.ajax({
			url :"${cp}/user/userPagingListAjaxHtml",
			data : "page="+page,
			success : function(data){
				
				/*
				   사용자 리스트 html.....
				   ------seperatir
				   페이지네이션 html...
				*/
				
				
				
				
			var htmlArr = data.split("=============seperator==============================");
				$("#userListTbody").html(htmlArr[0]);
				$("#Pagination").html(htmlArr[1]);
			}
		});
		
	}


		//문서로딩이 완료된 이후 이벤트 등록
		$(document).ready(function() {
			console.log("document ready");
			
			//getUserPageList(1,10);
			getUserPageListHtml(1);

			// msg 속성이 존재하면 alert, 존재하지 않으면 넘어가기
			<c:if test="${msg !=null}">
				alert("${msg}");
				<%session.removeAttribute("msg");%>
			</c:if>
			
			//사용자 tr 태그 클릭시 이벤트 핸들러
			$(".userTr").on("click", function() {
				console.log("userTr click");
				//클릭한 userTr태그의 userId 값을 출력
				// 				var userId = $(this).children()[1].innerText;
				// 				console.log("userId : " + userId);

				var userId = $(this).data("userid");

				// /user
				// 1. docuemnt
				//document.location = "/user?userId=" + userId;

				// 2. form
				$("#userId").val(userId);
				//$("#frm").attr("action", "/userAllList");
				$("#frm").submit();
			});
		});
	</script>

<form id="frm" action="${request.getContextPath()}/user/user"
	method="get">
	<input type="hidden" id="userId" name="userId" />
</form>


