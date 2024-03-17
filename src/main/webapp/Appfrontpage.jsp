<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
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
	<%@include file="./headerfooter/header.jsp"%>

<body style="background-color:aliceblue;">
	<!-- 
	<c:if test="${welcomeinfo != null}">
		<h3>${welcomeinfo}</h3>
	</c:if>
	-->
	

	<div class="container" style="margin-bottom:30px;" >
		<div style="padding-left:20px">
  <h1 style = "font-family:impact,serif;"><center>Welcome to DiligentSquad Snacks Portal<center></h1>
  
</div>
		<div class="row middleimg" style="margin-left:50px;">

			<div class="col-lg-6 snack">
				<img src="./img/samosa2.jpeg" alt="Samosa"/>
			</div>
			<div class="col-lg-6 snack">
				<img src="<c:url value='../img/micher.jpeg'/>" alt="Micher"/>
			</div>
			
		</div>
		<div class="row middleimg" style="margin-left:50px;margin-bottom:75px;">

			<div class="col-lg-6 snack">
				<img src="<c:url value='./img/redvelvetcake.jpeg'/>" alt="Cake"/>
			</div>
			<div class="col-lg-6 snack">
				<img src="<c:url value='./img/bunbutterjam.jpeg'/>" alt="Bunbutterjam"/>
			</div>

		</div>

	</div>
	
</body>
		<%@include file="./headerfooter/footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

</html>