<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<security:authorize access="hasAuthority('SuperAdmin')">
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
<security:authorize access="hasAuthority('User')">
<li><a href="/common/snackselectionform">ChooseSnack</a></li>
	<li><a href="/logout">Logout</a></li>
</security:authorize>

</body>
</html>