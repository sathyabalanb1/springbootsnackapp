<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snack Selection Form</title>
</head>
<body>
<%@include file="../headerfooter/header.jsp"%>

	<form action="/insertselection" method="post">
		<table>
			<caption>Snack Selection Form</caption>
			<tr>
				<td>Present Date</td>
				<td><input type="text" name="assigneddate" id="assigneddate"
					value="${assigneddate}" readonly></td>
				<br>
				<br>
			</tr>
			<tr>
				<td>Assigned Snack</td>
				<td><input type="text" name="assigneddate" id="assigneddate"
					value="${snackname}" readonly></td>
				<br>
				<br>
			</tr>
			<tr>
				<td>Purchased Vendor</td>
				<td><input type="text" name="assigneddate" id="assigneddate"
					value="${vendorname}" readonly></td>
				<br>
				<br>
			</tr>
			<tr>
				<td><input type="radio" name="isselected" value="True">Yes</input></td>
			</tr>
			<tr>
				<td><input type="radio" name="isselected" value="False">No</input></td>
			</tr>
			<tr>
				<td><input type="hidden" name="dsuser" value="${userid}"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="assignment" value="${assignmentid}"></td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" value="submit"></td>
			</tr>	
		</table>
	</form>
</body>
</html>