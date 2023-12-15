<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snack List</title>
</head>
<%@include file="../index.html"%>

<body>
<table border="1">
		<caption>Snacks List</caption>
		<thead>
			<tr class="tr tr-success">
				<td>Sl.No</td>
				<td>Snack Name</td>
				<td>Edit Snack</td>
				<td>Delete Snack</td>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="temp" items="${availablesnacks}" varStatus="loop">
				<tr>
					<td>${loop.index+1}</td>
					<td>${temp.snackname}</td>
					<td><a href="/snackupdateform?id=${temp.id}">Edit</a></td>		
					<td><a href="/deletesnack?id=${temp.id}" onclick="return confirm('Are you sure to delete?')">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
		
</table>

</body>
</html>