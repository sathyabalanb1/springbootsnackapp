<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assignment List</title>
</head>
<body>
<!-- ${assignments} -->  
	<%@include file="../index.html"%>
<table border="1">
		<caption>Snack Assignment List</caption>
		<thead>
			<tr class="tr tr-success">
				<td>Sl.No</td>
				<td>Assigned Date</td>
				<td>Assigned Snack</td>
				<td>Assigned Vendor</td>
				<td>Edit Assignment</td>
				<td>Delete Assignment</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="temp" items="${assignments}" varStatus="loop">
				<tr>
					<td>${loop.index+1}</td>
					<td>${temp.assigneddate}</td>
					<td>${temp.snack.snackname}</td>
					<td>${temp.getVendor().getVendorname()}</td>
					<td><a href="/assignmentupdateform?aid=${temp.id}">Edit</a></td>		
					<td><a href="/deleteassignment?aid=${temp.id}" onclick="return confirm('Are you sure to delete this Assignment?')">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>