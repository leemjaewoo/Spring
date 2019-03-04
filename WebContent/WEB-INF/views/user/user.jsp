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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- Custom styles for this template -->
    <link href="${cp} /css/dashboard.css" rel="stylesheet">


  </head>


    
          <%@ include file ="/WEB-INF/views/module/header.jsp" %>
      
        <div class="container-fluid">
      <div class="row">
          <%@ include file ="/WEB-INF/views/module/menu.jsp" %>
         
          <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">사용자 정보조회</h1>
          
					<form id="frm" name="userId" action="${cp}/usermodifyformcontroller" method="get">
					
					<input type="hidden" id="userId" name="userId" value="${uservo.userId }" />
					
					
					<div class="form-group">
						<label  for="userNm" class="col-sm-3 control-label">사진</label>
						<div class="col-sm-9">
						
						<img alt="" src="${cp }/user/profileImg?userId=${uservo.userId}">
							
							<c:choose>
							<c:when test="${uservo.filename ==null }">
							<img alt="" src="${cp }/upload/noimage.jpg"/>
							</c:when>
							<c:when test="${uservo.filename !=null }">
							<img alt="" src="${cp }/upload/${uservo.filename}"/>
							</c:when>
							</c:choose>
							
						
						
						</div>
					</div> 
					
					<div class="form-group">
						<label  for="userNm" class="col-sm-3 control-label">사용자 아이디</label>
						<div class="col-sm-9">
							<label class="control-label">${uservo.userId }</label>
						</div>
					</div>

					
					<div class="form-group">
						<label for="userNm" class="col-sm-3 control-label">사용자 이름</label>
						<div class="col-sm-9">
							<label class="control-label">${uservo.userNm }</label>
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="userNm" class="col-sm-3 control-label">별명</label>
						<div class="col-sm-9">
							<label class="control-label">${uservo.alias }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-3 control-label">주소</label>
						<div class="col-sm-9">
							<label class="control-label">${uservo.addr1 }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-3 control-label">상세주소</label>
						<div class="col-sm-9">
							<label class="control-label">${uservo.addr2 }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-3 control-label">우편번호</label>
						<div class="col-sm-9">
							<label class="control-label">${uservo.zipcode }</label>
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="pass" class="col-sm-3 control-label">Password</label>
						<div class="col-sm-9">
							<label class="control-label">****************</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-3 control-label">등록일자</label>
						<div class="col-sm-9">
							<label class="control-label"><fmt:formatDate value="${uservo.reg_dt }" pattern="yyyy-MM-dd"/></label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<input type="submit" id="editBtn" value="사용자수정"/>
						</div>
					</div>
					</form>
				
        
        
        </div>
      
      </div>
    </div>
    
        

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
		//문서로딩이 완료된 이후 이벤트 등록

		$(document).ready(function() {
			console.log("document ready");
			
			
			//server side 에서 비교
			<c:if test="${msg != null}">
			alert("${msg}");
			<%session.removeAttribute("msg");%>
			</c:if>
			
		});
			</script>	
			
  </body>
</html>
    
