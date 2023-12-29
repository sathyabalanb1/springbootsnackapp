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

<c:if test="${param.error!=null}">
<p style="color:red;">Username or Password May be Incorrect</p>
</c:if>
<%@include file="../index.html"%>

<%-- <c:if test="${param.error != null}">
   <div class="alert alert-danger">
       Invalid username and password.
   </div>
</c:if>
 --%>
<c:if test="${param.logout != null}">
   <div class="alert alert-success">
       You have been logged out successfully.
   </div>
</c:if>
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

</body>
</html>