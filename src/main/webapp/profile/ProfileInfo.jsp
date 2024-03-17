<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Edit Profile Info</title>
<%
    // Get the HttpSession object
    HttpSession s = request.getSession();

    // Retrieve the variable from the session
    
    
    int roleid = (int) s.getAttribute("roleid");
%>

</head>
<body>
<c:if test="${roleid == 1}">
<%@include file="../headerfooter/header.jsp"%>
</c:if>
<c:if test="${roleid == 2}">
<%@include file="../headerfooter/header.jsp"%>
</c:if>
<c:if test="${roleid == 3}">
<%@include file="../headerfooter/userheader.jsp"%>
</c:if>

<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">Edit Profile</h4>
					</div>
					<div class="card-body">
						<form name="myForm" id="myForm" action="/updateprofile" method="post">
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
								<c:if test="${info == false}">
		<p style="color:red;">Mail ID Already Exist</p>
			            </c:if>
							</div>
							<div class="mb-3">
								<label for="rolename" class="form-label">Role</label> 
								<input type="text" class="form-control" name="rolename" id="rolename" value="${rolename}" readonly>
							</div>
							<input type="hidden" name="employeeid" value="${employeeid}">
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
	<%@include file="../headerfooter/footer.jsp"%>
	<script src="../javascriptfiles/Profileformvalidation.js"></script>
	

</html>