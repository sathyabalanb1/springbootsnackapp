<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>  
</head>

<body>
<%@include file="index.jsp"%>
<c:if test="${info == true}">
<p>You have successfully registered</p>
</c:if>
<%@include file="./headerfooter/header.jsp"%>

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

</body>
<script src="./javascriptfiles/Registerformvalidation.js"></script>

</html>