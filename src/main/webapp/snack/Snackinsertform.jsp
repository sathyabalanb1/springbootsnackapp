<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snack Insert Form</title>
</head>
<%@include file="../headerfooter/header.jsp"%>

<body>
	<form action="/addsnack" id="snackinsertform" method="post">
		<table>			
			<tr>
				<td>Snackname</td>
				<td><input type="text" name="snackname" id="name"></td>
				<td><span class="error" id="snacknameerror" style="color:red;"></span></td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" value="submit"></td>
			</tr>
	</table>
	</form>
</body>
<script src="./javascriptfiles/Insertsnackformvalidation.js"></script>

</html>