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
<title>Vendor List</title>
</head>
<%@include file="../headerfooter/header.jsp"%>
<body>

	<div class="container mt-4">
		<table class="table table-primary">
			<caption>Vendor List</caption>

			<thead class="thead-dark">
				<tr>
					<th scope="col">Sl.No</th>
					<th scope="col">Vendor Name</th>
					<th scope="col">Location</th>
					<th scope="col">Mobile Number</th>
					<th scope="col">Landline Number</th>
					<th scope="col">Email</th>
					<th scope="col">Edit Vendor</th>
					<th scope="col">Delete Vendor</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="vendorentry" items="${vendors}" varStatus="loop">
					<tr>
						<td>${loop.index+1}</td>
						<td>${vendorentry.vendorname}</td>
						<td>${vendorentry.city}</td>
						<td>${vendorentry.mobilenumber}</td>
						<td>${vendorentry.landlinenumber}</td>
						<td>${vendorentry.email}</td>
						<!-- <td><a href="/${vendorentry.id}/54/skabsk">Edit</a></td> -->
						<td><a href="/admin/updatevendorform?vid=${vendorentry.id}">Edit</a></td>

						<td><a href="/admin/deletevendor?vid=${vendorentry.id}"
							onclick="return confirm('Are you sure to delete this Vendor?')">Delete</a></td>
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