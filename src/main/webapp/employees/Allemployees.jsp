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
<title>Insert title here</title>
</head>
<body>
	<%@include file="../headerfooter/header.jsp"%>

	<div class="container mt-4">
		<table class="table table-primary">
			<caption>Employee List</caption>

			<thead class="thead-dark">
				<tr>
					<th scope="col">Sl.No</th>
					<th scope="col">Employee Name</th>
					<th scope="col">Role</th>
					<th scope="col">Action</th>
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
							<td><a href="/removeadmin?id=${entry.getId()}"
								onclick="return confirm('Are you sure to make this Admin as User?')">Remove
									Admin</a></td>
						</c:if>
						<c:if test="${entry.getRoleid().getId() == 3}">
							<td><a href="/makeadmin?id=${entry.getId()}"
								onclick="return confirm('Are you sure to make this user as Admin?')">Make
									Admin</a></td>
						</c:if>

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