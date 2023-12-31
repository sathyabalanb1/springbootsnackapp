<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor Update Form</title>
</head>
<body>
<%@include file="../headerfooter/header.jsp"%>

<form   action="/updatevendor" id="vendorinsertform" method="post">
		<table>			
			<tr>				
				<td>Vendorname</td>
				<td><input type="text" name="vendorname" id="vendorname" value="${existingvendorname}"></td>
				<td><span class="error" id="vendornameerror" style="color:red;"></span></td>
				<td><input type="hidden" name="id" value="${existingvendorid}"></td>
			</tr>
			<tr>
				<td>City Name</td>
				<td><input type="text" name="city" id="city" value="${existingcityname}"></td>
				<td><span class="error" id="citynameerror" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>State Name</td>
				<td><input type="text" name="state" id="state" value="${existingstatename}"></td>
				<td><span class="error" id="statenameerror" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Country Name</td>
				<td><input type="text" name="country" id="country" value="${existingcountryname}"></td>
				<td><span class="error" id="countrynameerror" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Pincode</td>
				<td><input type="text" name="pincode" id="pincode" value="${existingpincode}"></td>
				<td><span class="error" id="pincodeerror" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobilenumber" id="mobilenumber" value="${existingmobilenumber}"></td>
				<td><span class="error" id="mobilenumbererror"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Landline Number</td>
				<td><input type="text" name="landlinenumber" id="landlinenumber" value="${existinglandlinenumber}"></td>
				<td><span class="error" id="landlinenumbererror"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email" value="${existingemail}"></td>
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