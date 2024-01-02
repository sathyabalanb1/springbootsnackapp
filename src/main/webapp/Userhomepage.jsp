<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Homepage</title>
</head>
<body>
<%@include file="./headerfooter/header.jsp"%>

<c:if test="${noassignment != null}">
<p>Dear ${employeename}</p><br>
<p>${noassignment}</p>
</c:if>

<c:if test="${empname != null}">
<p>Hi ${empname}</p><br>
<p>You have chosen ${selectionvalue} for Today's Snack</p>
</c:if>

</body>
</html>