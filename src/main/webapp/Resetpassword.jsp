<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Reset Password</title>
</head>
<body>
<%@include file="./headerfooter/header.jsp"%>
<c:if test="${samepassword != null}">
<p>${samepassword}</p>
</c:if>
<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">Reset Password</h4>
					</div>
					<div class="card-body">
						<form name="myForm" id="myForm" action="/resetpassword" method="post">
							<div class="mb-3">
								<label for="newpassword" class="form-label">Enter the New Password</label> <input
									type="text" name="newpassword" id="newpassword" class="form-control">
								<span class="error" id="newpasswordError" style="color: red;"></span>
							</div>
							<input type="hidden" name="oldpassword" value="${user.getPassword()}">
							<input type="hidden" name="email" value="${user.getEmail()}">
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<%@include file="./headerfooter/footer.jsp"%>

</html>