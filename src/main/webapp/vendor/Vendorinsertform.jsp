<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Vendor Insert Form</title>
</head>
<%@include file="../headerfooter/header.jsp"%>
<body>
<!--  
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
-->
<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">New Vendor Insert</h4>
					</div>
					<div class="card-body">
						<form action="/addvendor" id="vendorinsertform" method="post">
							<div class="mb-3">
								<label for="vendorname" class="form-label">Vendor Name</label> 
								<input type="text" class="form-control" name="vendorname" id="vendorname">
								<span class="error" id="vendornameerror" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<label for="city" class="form-label">City Name</label> 
								<input type="text" class="form-control" name="city" id="city">
								<span class="error" id="citynameerror" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<label for="state" class="form-label">State Name</label> 
								<input type="text" class="form-control" name="state" id="state">
								<span class="error" id="statenameerror" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<label for="country" class="form-label">Country Name</label> 
								<input type="text" class="form-control" name="country" id="country">
								<span class="error" id="countrynameerror" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<label for="pincode" class="form-label">Pincode</label> 
								<input type="text" class="form-control" name="pincode" id="pincode">								
								<span class="error" id="pincodeerror" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<label for="mobilenumber" class="form-label">Mobile Number</label> 
								<input type="text" class="form-control" name="mobilenumber" id="mobilenumber">								
								<span class="error" id="mobilenumbererror" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<label for="landlinenumber" class="form-label">Landline Number</label> 
								<input type="text" class="form-control" name="landlinenumber" id="landlinenumber">								
								<span class="error" id="landlinenumbererror" style="color: red;"></span>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email</label> 
								<input type="text" class="form-control" name="email" id="email">								
								<span class="error" id="emailerror" style="color: red;"></span>
							</div>
							<div class="mb-3 snackappformbutton">
							<button type="submit" class="btn btn-primary">Insert Vendor</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
	<%@include file="../headerfooter/footer.jsp"%>
<script  src="../javascriptfiles/Insertvendorformvalidation.js"></script>

</html>