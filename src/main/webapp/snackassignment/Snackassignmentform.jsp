<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%@ page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SnackAssignment</title>
</head>
<%@include file="../index.html"%>

<body>
	<c:choose>
		<c:when test="${assignmentinfo == true}">
			<p class="text-success">Snack is Assigned Successfully</p>
		</c:when>
		<c:when test="${assignmentinfo == false}">
			<p class="text-danger">Already Snack is Assigned for Today</p>
		</c:when>
	</c:choose>
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
</body>
</html>