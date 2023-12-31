<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snackupdate Form</title>
</head>
<body>
<%@include file="../headerfooter/header.jsp"%>

<form   action="/updatesnack" id="snackinsertform" method="post">
		<table>			
			<tr>				
				<td>Snackname</td>
				<td><input type="text" name="snackname" id="name" value="${existingsnack}"></td>
				<td><span class="error" id="snacknameerror" style="color:red;"></span></td>
				<td><input type="hidden" name="id" value="${existingsnackid}"></td>
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