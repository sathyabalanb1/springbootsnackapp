<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Front Page</title>
</head>
<body>
<security:authorize access="isAuthenticated()">
<li><a href="./index.html">Home Page</a></li>
	<li><a href="/admin/addsnackform">Insert Snack</a></li>
	<li><a href="/admin/snacks">Snack List</a></li>
	<li><a href="/admin/vendorinsertform">Insert Vendor</a></li>
	<li><a href="/admin/vendors">Vendor List</a></li>
	<li><a href="/admin/snackassignmentform">Assign Snack</a></li>
	<li><a href="/assignments">Assignment List</a></li>
	<li><a href="/allemployees">Employee List</a></li>
	<li><a href="/common/snackselectionform">ChooseSnack</a></li>
	<li><a href="/logout">Logout</a></li>
</security:authorize>
	<security:authorize access="isAnonymous()">
<li><a href="/registerform">Register </a></li>
<li><a href="/signin">Login</a></li>
</security:authorize>
	
	
	
	
</body>
</html>