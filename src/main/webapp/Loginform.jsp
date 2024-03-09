<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<%@include file="./headerfooter/header.jsp"%>

	<!--<c:if test="${validuser==true}"><p>You have successfully logged in</p></c:if> -->

	<c:if test="${info==false}">
		<p>Invalid Login Credentials</p>
	</c:if>
 
	<c:if test="${param.error!=null}">
		<p style="color: red;">Username or Password May be Incorrect</p>
	</c:if>
	
	<c:if test="${param.error!=null}">
		<p style="color: red;">"${param}"</p>
	</c:if>
	
	<c:if test="${accountlockerror eq 'true'}">
		<p style="color: red;">Account is Locked</p>
	</c:if>
	<c:if test="${param.loginerror != null}">
    <p style="color: red;">Invalid Login Credentials abcdefghijklmnopqrstuvwxyz</p>
    </c:if>
	
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">You have been logged out
			successfully.</div>
	</c:if>
 	
	<c:if test="${param.error!=null}">
    <div class="text-danger">
        <p>${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}isisi</p>
    </div>
</c:if>

	<!-- 
<form action="/login" method="post">
		<table>
			
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
-->


	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">Login to SnackApp</h4>
					</div>
					<div class="card-body">
						<form action="/login" method="post">
							<div class="mb-3">
								<label for="username" class="form-label">User Name</label> 
								<input
									type="text" class="form-control" name="username" id="username"
									aria-describedby="emailHelp">
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">Password</label> 
								<input type="password" class="form-control" name="password" id="password">
							</div>
							<div class="mb-3 snackappformbutton">
							<button type="submit" class="btn btn-primary">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="./headerfooter/footer.jsp"%>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>