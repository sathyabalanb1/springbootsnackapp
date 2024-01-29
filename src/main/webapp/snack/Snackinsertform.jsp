<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Snack Insert Form</title>
</head>
<%@include file="../headerfooter/header.jsp"%>

<body>
<!--  
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
-->	
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">Add New Snack</h4>
					</div>
					<div class="card-body">
						<form action="/addsnack" id="snackinsertform" method="post">
							<div class="mb-3">
								<label for="name" class="form-label">Snackname</label> 
								<input type="text" class="form-control" name="snackname" id="name">
								<span class="error" id="snacknameerror" style="color:red;"></span>
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
</body>
<%@include file="../headerfooter/footer.jsp"%>
<script src="../javascriptfiles/Insertsnackformvalidation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

</html>