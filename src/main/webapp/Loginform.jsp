<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
<!--<c:if test="${validuser==true}"><p>You have successfully logged in</p></c:if> -->
<c:if test="${info==false}"><p style="color:red;">Invalid Login Credentials</p></c:if>
<%@include file="index.html"%>


<form action="validUser" method="post">
		<table>
			
			<tr>
				<td>User Name</td>
				<td><input type="text" name="email"></td>
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

</body>
</html>