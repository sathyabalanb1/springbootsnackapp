<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../headerfooter/header.jsp"%>


<table border="1">
<caption>Employee List</caption>
<thead>
<tr>
<td>Sl. No</td>
<td>Employee Name</td>
<td>Role</td>
<td>Action</td>
</tr>
</thead>
<tbody>
<c:forEach var="entry" items="${allemployees}" varStatus="iter">
<tr>
<td>${iter.index+1}</td>
<td>${entry.name}</td>
<td>${entry.getRoleid().getRolename()}</td>
<c:if test="${entry.getRoleid().getId() == 1}">
<td><a href="">Remove SuperAdmin</a></td>
</c:if>
<c:if test="${entry.getRoleid().getId() == 2}">
<td><a href="/removeadmin?id=${entry.getId()}" onclick="return confirm('Are you sure to make this Admin as User?')">Remove Admin</a></td>
</c:if>
<c:if test="${entry.getRoleid().getId() == 3}">
<td><a href="/makeadmin?id=${entry.getId()}" onclick="return confirm('Are you sure to make this user as Admin?')">Make Admin</a></td>
</c:if>

</tr>
</c:forEach>
</tbody>

</table>

</body>
</html>