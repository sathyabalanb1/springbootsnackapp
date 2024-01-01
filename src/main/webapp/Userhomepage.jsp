<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Homepage</title>
</head>
<body>
<%@include file="./headerfooter/header.jsp"%>
<c:if test="${noassignment != null}">
<p>Dear User</p><br>
<p>${noassignment}</p>
</c:if>

<p>This is User Homepage</p>
</body>
</html>