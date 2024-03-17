<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="./headerfooter/header.jsp"%>

<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">Edit Profile</h4>
					</div>
					<div class="card-body">
						<form action="" method="">
							<div class="mb-3">
								<label for="empname" class="form-label">Name</label> 
								<input type="text" class="form-control" name="empname" id="empname" value="${empname}">
								<span class="error" id="nameError" style="color:red;"></span>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email</label> 
								<input type="text" class="form-control" name="email" id="email" 
								aria-describedby="emailHelp" value="${email}">
								<span class="error" id="emailError" style="color:red;"></span>
							</div>
							<div class="mb-3">
								<label for="rolename" class="form-label">Role</label> 
								<input type="text" class="form-control" name="rolename" id="rolename" value="${rolename}" readonly>
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
	
<%@include file="./headerfooter/footer.jsp"%>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>