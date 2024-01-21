<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Snack List</title>
</head>
<%@include file="../headerfooter/header.jsp"%>

<body>
<c:if test="${deleteinfo != null}">
<p class="text-success">Assigned Snack Cannot Be Removed</p>
</c:if>
<div class="container mt-4">
		<table class="table table-primary">
		<caption>Snacks List</caption>
			
			<thead class="thead-dark">
			<tr>
				<th scope="col">Sl.No</th>
				<th scope="col">Snack Name</th>
				<th scope="col">Edit Snack</th>
				<th scope="col">Delete Snack</th>
			</tr>
		</thead>
			<tbody>

				<c:forEach var="temp" items="${availablesnacks}" varStatus="loop">
				<tr>
					<td>${loop.index+1}</td>
					<td>${temp.snackname}</td>
					<td><a href="/admin/snackupdateform?id=${temp.id}">Edit</a></td>		
					<td><a href="/admin/deletesnack?id=${temp.id}" onclick="return confirm('Are you sure to delete?')">Delete</a></td>
				</tr>
					

				</c:forEach>
			</tbody>


		</table>
	</div>

<%@include file="../headerfooter/footer.jsp"%>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../javascriptfiles/jquery.js" type="text/javascript"></script>

</html>