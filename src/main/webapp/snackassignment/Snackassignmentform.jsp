<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="UTF-8">
<title>SnackAssignment</title>
<link href="../css/noassignment.css" rel="stylesheet"/>

</head>
<%@include file="../headerfooter/header.jsp"%>

<body>
	<c:choose>
		<c:when test="${assignmentinfo == true}">
			<p class="text-success">Snack is Assigned Successfully</p>
		</c:when>
		<c:when test="${assignmentinfo == false}">
			<p class="text-danger">Already Snack is Assigned for Today</p>
		</c:when>
	</c:choose>
	<c:if test="${noassignment != null }">
		<p class="blink-text">Today's Snack is Not Yet Assigned</p>
	</c:if>
	<!--  
	<form action="/addassignment" id="snackassignmentform" method="post">
		<table>
			<tr>
				<td>Present Date</td>
				<td><input type="date" name="dates" id="assigneddate"
					min="<%=LocalDate.now()%>" max="<%=LocalDate.now()%>"></td>
				<td><span class="error" id="assigneddateerror"
					style="color: red;"></span></td>
			</tr>

			<tr>
				<td>Snack</td>
				<td><select name="snacksId">
						<option value="" selected disabled>Choose a Snack</option>
						<c:forEach var="snackentry" items="${snacklist}" varStatus="loop">
							<option value="${snackentry.id}">${snackentry.snackname}</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td>Vendor</td>
				<td><select name="vendorId">
						<option value="" selected disabled>Choose a Vendor</option>

						<c:forEach var="vendorentry" items="${vendorlist}"
							varStatus="loop">
							<option value="${vendorentry.id}">${vendorentry.vendorname}</option>
						</c:forEach>

				</select></td>
			</tr>

			<tr>
				<td>Submit</td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
-->
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">Snack Assignment</h4>
					</div>
					<div class="card-body">
						<form action="/addassignment" id="snackassignmentform"
							method="post">
							<div class="mb-3">
								<label for="dates" class="form-label">Present Date</label> <input
									type="date" class="form-control" name="dates" id="assigneddate"
									min="<%=LocalDate.now()%>" max="<%=LocalDate.now()%>">
								<span class="error" id="assigneddateerror" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<label for="snackname" class="form-label">Snack</label> <select
									name="snacksId" class="form-select">
									<option value="" selected disabled>Choose a Snack</option>
									<c:forEach var="snackentry" items="${snacklist}"
										varStatus="loop">
										<option id="snackname"  value="${snackentry.id}">${snackentry.snackname}</option>
									</c:forEach>

								</select>
							</div>
							<div class="mb-3">
								<label for="vendorname" class="form-label">Vendor</label> <select
								name="vendorId" class="form-select">
								<option value="" selected disabled>Choose a Vendor</option>

								<c:forEach var="vendorentry" items="${vendorlist}"
									varStatus="loop">
									<option id="vendorname" class="form-control" value="${vendorentry.id}">${vendorentry.vendorname}</option>
								</c:forEach>

								</select>
							</div>
							<div class="mb-3 snackappformbutton">
							<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>