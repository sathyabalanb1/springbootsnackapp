<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../headerfooter/header.jsp"%>

<c:choose>
<c:when test="${selectiontimeerror != null}">
			<div class="container my-5">
				<div class="row justify-content-center">
					<div class="col-md-6">
						<div class="card">
							<div class="card-header bg-primary text-white">
								<h4 class="mb-0">ChooseSnack Info</h4>
							</div>
							<div class="card-body">
								<div class="mb-3">
									<p>Dear <b style="color:green;">${empname}</b></p>
								</div>
								<div class="mb-3">
									<p>${selectiontimeerror}</p>
								</div>
								<div class="mb-3">
									<p>${selectiontimeinfo}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		<div class="container my-5">
				<div class="row justify-content-center">
					<div class="col-md-6">
						<div class="card">
							<div class="card-header bg-primary text-white">
								<h4 class="mb-0">Update Your Choice</h4>
							</div>
							<div class="card-body">
								<form action="/updateselection" method="post">
									<div class="mb-3">
										<label for="username" class="form-label">Present Date</label>
										<input type="text" class="form-control" name="assigneddate"
											id="assigneddate" value="${assigneddate}" readonly>
									</div>
									<div class="mb-3">
										<label for="assignedsnack" class="form-label">Assigned
											Snack</label> <input type="text" class="form-control"
											name="assigneddate" id="assignedsnack" value="${snackname}"
											readonly>
									</div>
									<div class="mb-3">
										<label for="purchasedvendor" class="form-label">Purchased
											Vendor</label> <input type="text" class="form-control"
											name="purchasedvendor" id="purchasedvendor"
											value="${vendorname}" readonly>
									</div>
									<div class="mb-3">
										<input type="radio" name="enabled" value="True">Yes</input>
									</div>
									<div class="mb-3">
										<input type="radio" name="enabled" value="False">No</input>
									</div>
									<input type="hidden" name="dsuser" value="${userid}"> <input
										type="hidden" name="assignment" value="${assignmentid}">
									<div class="mb-3 snackappformbutton">
									<button type="submit" class="btn btn-primary">Update Selection</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</c:otherwise>
	</c:choose>
		<%@include file="../headerfooter/footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>