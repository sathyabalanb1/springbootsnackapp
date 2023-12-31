<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor Insert Form</title>
</head>
<%@include file="../headerfooter/header.jsp"%>

<body>

	<form action="/addvendor" id="vendorinsertform" method="post">
		<table>
			<tr>
				<td>Vendor Name</td>
				<td><input type="text" name="vendorname" id="vendorname"></td>
				<td><span class="error" id="vendornameerror"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td>City Name</td>
				<td><input type="text" name="city" id="city"></td>
				<td><span class="error" id="citynameerror" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>State Name</td>
				<td><input type="text" name="state" id="state"></td>
				<td><span class="error" id="statenameerror" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Country Name</td>
				<td><input type="text" name="country" id="country"></td>
				<td><span class="error" id="countrynameerror"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Pincode</td>
				<td><input type="text" name="pincode" id="pincode"></td>
				<td><span class="error" id="pincodeerror" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobilenumber" id="mobilenumber"></td>
				<td><span class="error" id="mobilenumbererror"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Landline Number</td>
				<td><input type="text" name="landlinenumber" id="landlinenumber"></td>
				<td><span class="error" id="landlinenumbererror"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email"></td>
				<td><span class="error" id="emailerror" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>

</body>
<script src="./javascriptfiles/Insertvendorformvalidation.js"></script>

</html>