<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style>

body{
	background: url("/img/admindashboardbackground.jpg");
}

.grad1 {
  height: auto;
  background-color: red; /* For browsers that do not support gradients */
  background-image: linear-gradient(to bottom right, #ff9a9e, #fecfef);
  border-radius: 10px;
  text-align: center;
  border-style: solid;
  width:20% !important;
  margin-right: 3%;
}
.grad3 {
  height: auto;
  background-color: red; /* For browsers that do not support gradients */
  background-image: linear-gradient(to bottom right, #56C596, #7BE495);
}
.grad4 {
  height: auto;
  background-color: red; /* For browsers that do not support gradients */
  background-image: linear-gradient(to bottom right, #FF0000, #FFFFFF);
}
.grad5 {
  height: auto;
  background-color: red; /* For browsers that do not support gradients */
  background-image: linear-gradient(to bottom right, #FFFF00, #FFFFFF);
}
.boxescenter{
justify-content: center;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://site-assets.fontawesome.com/releases/v6.1.1/css/all.css">
<link href="/css/topnavigation.css" rel="stylesheet" type="text/css"/>
<link href="/css/footer.css" rel="stylesheet" type="text/css"/>
<meta charset="UTF-8">
<title>Admin Home Page</title>
<link href="../css/noassignment.css" rel="stylesheet" />
</head>
<body>
	<%@include file="./headerfooter/header.jsp"%>

	<p>Hi <b style="color:green;">${authenticatedperson}</b></p>
	<!-- 
	<div class="banner">
		<img src="/img/cake.jpeg" alt="Samosaksksk" />
	</div>
	-->

	<div class="container">
		<div class="row">
			<h5>
				<b style="color:red;background-color:black;">Employee Details</b>
			</h5>
		</div>

		<div class="row boxescenter">
			<div class="col-md-3  mr-3 p-3 grad1">
				<i class="fa-solid fa-users fa-2xl"></i><br> Total Employees<br>

				<b>${totalemployees}</b>
			</div>
			<div class="col-md-3  mr-3 p-3 grad1">
				<i class="fa-solid fa-users fa-2xl"></i><br> No of SuperAdmins<br>

				<b>${superadmincount}</b>
			</div>
			<div class="col-md-3 m-10 p-3 grad1">
				<i class="fa-solid fa-users fa-2xl"></i><br> No of Admins<br>

				<b>${admincount}</b>
			</div>
			<div class="col-md-3  mr-3 p-3 grad1">
				<i class="fa-solid fa-users fa-2xl"></i><br> No of Users<br>

				<b>${usercount}</b>
			</div>
		</div>

		<c:choose>
			<c:when test="${assignedsnack != null}">
				<div class="row">
					<p>
						<b>Today Assigned Snack is </b><b class="blink-text">${assignedsnack}</b>
					</p>
				</div>
			</c:when>
			<c:when test="${assignmentinfo == null}">
					<p class="blink-text">Today's Snack is Not Yet Assigned</p>
			</c:when>
		</c:choose>
		<div class="row">
			<h5>
				<b style="color:red;background-color:black;">Today Selection Details</b>
			</h5>
		</div>

		<div class="row" style="margin-bottom:10px;">
			<div class="col-md-3   p-3 grad3"
				style="border-radius: 10px; text-align: center; border-style: solid; margin-right:3%;margin-left:4%;">
				<i class="fa-solid fa-thumbs-up fa-2xl"></i><br> Yes<br> <b>${yesselection}</b>
			</div>
			<br>
			<div class="col-md-3 mr-3 ml-5 p-3 grad4"
				style="border-radius: 10px; text-align: center; border-style: solid; margin-right:3%;">
				<i class="fa-solid fa-thumbs-down fa-2xl"></i><br> No<br>
				<b>${noselection}</b>
			</div>
			<br>
			<div class="col-md-3 mr-3 p-3 ml-5 grad5"
				style="border-radius: 10px; text-align: center; border-style: solid;margin-right:3%;">
				<i class="fa-solid fa-face-meh-blank fa-2xl"></i><br> No
				Response<br> <b>${noresponse}</b>
			</div>
		</div>
	</div>
	<%@include file="./headerfooter/footer.jsp"%>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

</html>