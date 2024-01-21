<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style>
.middleimg img{
  height: 150px;
  width: 400px;
  padding: 5px;
}
</style>
<meta charset="UTF-8">
<title>App Front Page</title>
</head>
<body>
	<%@include file="./headerfooter/header.jsp"%>
	<!-- 
	<c:if test="${welcomeinfo != null}">
		<h3>${welcomeinfo}</h3>
	</c:if>
	-->
	<div style="padding-left:20px">
  <h1><center>Welcome to DiligentSquad Snack Site<center></h1>
  
</div>

	<div class="container">

		<div class="row middleimg">

			<div class="col-lg-6">
				<img src="./img/samosa2.jpeg" alt="Samosa"/>
			</div>
			<div class="col-lg-6">
				<img src="<c:url value='../img/micher.jpeg'/>" alt="Micher"/>
			</div>
			
		</div>
		<div class="row middleimg">

			<div class="col-lg-6">
				<img src="<c:url value='./img/cake.jpeg'/>" alt="Cake"/>
			</div>
			<div class="col-lg-6">
				<img src="<c:url value='./img/bunbutterjam.jpeg'/>" alt="Bunbutterjam"/>
			</div>

		</div>

	</div>
</body>
</html>