<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link href="../css/topnavigation.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<security:authorize access="isAuthenticated() and hasAnyAuthority('SuperAdmin','Admin')">
	
	<nav class="navbar">
	    <div class="logo">DS Snackapp</div>
	    <ul class="nav-links">
	      <div class="menu">
	        <li><a href="/admin/adminhomepage">Home</a></li>
	        
	        <li class="services">
	        <a href="/">Snacks</a>
	        <ul class="dropdown">
	        <li><a href="/common/snackselectionform">ChooseSnack</a></li>
	        <li><a href="/admin/addsnackform">Insert Snack</a></li>
	        <li><a href="/admin/snacks">Snack List</a></li>
	        </ul>	
	        </li>
	        
	        <li class="services">
	        <a href="/">Vendors</a>
	        <ul class="dropdown">
	        <li><a href="/admin/vendorinsertform">Insert Vendor</a></li>
	        <li><a href="/admin/vendors">Vendor List</a></li>
	        </ul>	
	        </li>
	        
	        <li class="services">
	        <a href="/">Assignments</a>
	        <ul class="dropdown">
	        <li><a href="/admin/snackassignmentform">Assign Snack</a></li>
	        <li><a href="/assignments">Assignment List</a></li>
	        </ul>	
	        </li>
	        
	        <li><a href="/allemployees">Employee List</a></li>
	        
	        <li><a href="/admin/reportform">Report</a></li>
	        
	        <li><a href="/logout">Logout</a></li>
	        
	        </div>
    </ul>
  </nav>
	        
	
    </security:authorize>
	<security:authorize access="isAuthenticated() and hasAuthority('User')">
		<li><a href="/common/snackselectionform">ChooseSnack</a></li>
			<li><a href="/logout">Logout</a></li>
	</security:authorize>
	<security:authorize access="isAnonymous()">
       <li><a href="/registerform">Register </a></li>
       <li><a href="/signin">Login</a></li>
    </security:authorize>
		
	

		
</body>
</html>