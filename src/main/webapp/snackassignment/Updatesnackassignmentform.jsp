<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateAssignment</title>
</head>
<%@include file="../index.html"%>

<body>
	<form action="/updateassignment" id="updatesnackassignmentform" method="get">
		<table>
			<tr>
				<td>Today Assigned Snack</td>
				<td><input type="text" name="snackname" id="snackname"
					value="${snackname}"></td>
				<td><span class="error" id="assigneddateerror"
					style="color: red;"></span></td>
				<td><input type="hidden" name="assignmentid" value="${assignmentid}"></td>
			</tr>

			<tr>
				<td>Change Snack</td>
				<td><select name="snacksId">
						<c:forEach var="snackentry" items="${snacklist}" varStatus="loop">
							<option value="${snackentry.id}">${snackentry.snackname}</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td>Change Vendor</td>
				<td><select name="vendorId">
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