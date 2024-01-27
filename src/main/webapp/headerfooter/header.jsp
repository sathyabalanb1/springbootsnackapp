<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<link href="../css/topnavigation.css" type="text/css" rel="stylesheet"/>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<security:authorize access="isAuthenticated() and hasAnyAuthority('SuperAdmin','Admin')">
	
	<nav class="navbar">
	    <img src="../img/dsquadlogo.png" alt="Dsquad"/>
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
       	<nav class="navbar">
       	    <img src="../img/dsquadlogo.png" alt="Dsquad"/>
       	    <ul class="nav-links">
       <div class="menu">
       <li><a href="/registerform">Register</a></li>
       <li><a href="/signin">Login</a></li>
       </div>
       </ul>
       </nav>
    </security:authorize>
		
	

		
</body>
</html>