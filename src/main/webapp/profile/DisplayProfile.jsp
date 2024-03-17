<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Profile Info</title>
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
								<h4 class="mb-0">Profile Info</h4>
							</div>
							<div class="card-body">
								<div class="mb-3">
									<p>Name: <b style="color:green;">${empname}</b></p>
								</div>
								<div class="mb-3">
									<p>Email ID: <b style="color:green;">${email}</b></p>
								</div>
								<div class="mb-3">
									<p>Role: <b style="color:green;">${rolename}</b></p>
								</div>
								<div class="mb-3 snackappformbutton">
									<a href="/common/editprofile" class="btn btn-primary">Edit Profile</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

	<%@include file="../headerfooter/footer.jsp"%>

</html>