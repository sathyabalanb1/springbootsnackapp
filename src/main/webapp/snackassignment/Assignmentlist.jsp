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
<title>Assignment List</title>
</head>
<body>
<!-- ${assignments} -->  
<%@include file="../headerfooter/header.jsp"%>

<div class="container mt-4">
		<table class="table table-primary">
			<caption>SnackAssignment List</caption>

			<thead class="thead-dark">
				<tr>
					<th scope="col">Sl.No</th>
					<th scope="col">Assigned Date</th>
					<th scope="col">Assigned Snack</th>
					<th scope="col">Assigned Vendor</th>
					<th scope="col">Edit Assignment</th>
					<th scope="col">Delete Assignment</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="temp" items="${assignments}" varStatus="loop">
					<tr>
					<td>${loop.index+1}</td>
					<td>${temp.assigneddate}</td>
					<td>${temp.snack.snackname}</td>
					<td>${temp.getVendor().getVendorname()}</td>
					<c:choose>
		            <c:when test="${temp.assigneddate != currentdate}">
		            <td><a href="/assignmentupdateform?aid=${temp.id}" style="pointer-events: none;color:black;">Edit</a></td>
				    </c:when>
					<c:otherwise>
						<td><a href="/admin/snackassignmentform?aid=${temp.id}">Edit</a></td>
                    </c:otherwise>
	                </c:choose>
	                
	                <c:choose>
		            <c:when test="${temp.assigneddate != currentdate}">
					<td><a href="/deleteassignment?aid=${temp.id}" style="pointer-events: none;color:black;" onclick="return confirm('Are you sure to delete this Assignment?')">Delete</a></td>
				    </c:when>
					<c:otherwise>
					<td><a href="/deleteassignment?aid=${temp.id}" onclick="return confirm('Are you sure to delete this Assignment?')">Delete</a></td>
                    </c:otherwise>
	                </c:choose>
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