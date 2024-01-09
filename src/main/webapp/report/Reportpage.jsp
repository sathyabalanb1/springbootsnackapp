<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="java.time.LocalDate"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Report Page</title>
</head>
<body>
<%@include file="../headerfooter/header.jsp"%>

<form action="" id="" onsubmit="findCountinfo()">
		<table>
			<tr>
				<td>Present Date</td>
				<td><input type="date" name="resultdate" id="resultdate"></td>
				<td><span class="error" id="resultdateerror"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" value="submit" onclick = "return findCountinfo()" ></td>
			</tr>
		</table>
</form>

<b><div id="selectionreport"></div></b>

</body>
<script src="/javascriptfiles/Reportformimpl.js" type="text/javascript"></script>
</html>