<%@page import="kr.or.ddit.lprod.model.ProdVO"%>
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
    <link href="/css/dashboard.css" rel="stylesheet">

	
  </head>

  <body>

    
          <%@ include file ="/WEB-INF/views/module/header.jsp" %>
      
        <div class="container-fluid">
      <div class="row">
          <%@ include file ="/WEB-INF/views/module/menu.jsp" %>
         
          <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">제품 전체 리스트</h1>
        <!-- userList 정보를 화면에 출력하는 로직 작성 -->
        <%-- <%=request.getAttribute("list") %> --%>
        
        
         <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>prod_id</th>
                  <th>prod_gu</th>
                  <th>등록일시</th>
                </tr>
              </thead>
             
              <tbody>
              <c:forEach items="${selectLprod}" var="list">
                <tr>
                  <td></td>
                  <td>${list.prod_id }</td>
                  <td>${list.prod_name }</td>
                  <td>${list.prod_buyer }</td>
                </tr>
             </c:forEach>
              </tbody>
            </table>
          </div>
        
        
        </div>
      
      </div>
    </div>
    
        

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
  
  </body>
</html>
    
