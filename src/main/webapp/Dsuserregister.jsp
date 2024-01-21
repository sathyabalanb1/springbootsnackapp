<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Registration</title>  
</head>

<body>
<%@include file="./headerfooter/header.jsp"%>
<c:if test="${info == true}">
<p>You have successfully registered</p>
</c:if>
 <!--     
	<form name="myForm" id="myForm" action="/addDsuser" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" id="name"></td>
				<td><span class="error" id="nameError" style="color:red;"></span></td>
				<br>
				<br>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email"></td>
				<td><span class="error" id="emailError" style="color:red;"></span></td>
				<td><c:if test="${info == false}">
		<p style="color:red;">Mail ID Already Exist</p>
			            </c:if>
		</td>
				<br>
				<br>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password"></td>
				<td><span class="error" id="passwordError" style="color:red;"></span></td>
				<br>
				<br>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" value="register"></td>
			</tr>			
		</table>
	</form>
-->	
   
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">User Registration</h4>
					</div>
					<div class="card-body">
						<form name="myForm" id="myForm" action="/addDsuser" method="post">
							<div class="mb-3">
								<label for="name" class="form-label">Name</label> 
								<input type="text" name="name" id="name"class="form-control">
								<span class="error" id="nameError" style="color:red;"></span>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email</label> 
								<input type="text" class="form-control" name="email" id="email">
								<span class="error" id="emailError" style="color:red;"></span>
								<c:if test="${info == false}">
		<p style="color:red;">Mail ID Already Exist</p>
			            </c:if>
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">Password</label> 
								<input type="password" class="form-control" name="password" id="password">
								<span class="error" id="passwordError" style="color:red;"></span>
							</div>
							<button type="submit" class="btn btn-primary">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="./headerfooter/footer.jsp"%>

<script src="./javascriptfiles/Registerformvalidation.js"></script>
</html>