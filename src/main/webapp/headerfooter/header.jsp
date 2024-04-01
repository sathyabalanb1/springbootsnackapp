<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.navbar{
justify-content: space-between;
}
</style>

<link href="../css/topnavigation.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet"
	href="https://site-assets.fontawesome.com/releases/v6.1.1/css/all.css">
<meta charset="UTF-8">
<title></title>
<%
    // Get the HttpSession object
    HttpSession sn = request.getSession();

    // Retrieve the variable from the session
    String sharedData = (String) sn.getAttribute("empname");
    
    String currentstatus = (String) sn.getAttribute("currentstatus");
%>
</head>
<body>
	<c:if test="${currentstatus != null}">

	<security:authorize access="isAuthenticated() and hasAnyAuthority('SuperAdmin','Admin')">
	
	<nav class="navbar" style="width:100%;">
	    <img src="../img/dsquadlogo.png" alt="Dsquad"/>
	    <span style="padding-left:2%;"><i class="fa fa-user-alt" style="margin-right:5px;"></i><%= sharedData %></span>	    
	    <ul class="nav-links" style="padding-left:18%;">
	      <div class="menu">
	        <li><a href="/admin/adminhomepage">Home</a></li>
	        <li><a href="/common/profile">Profile</a></li>
	        
	        <li class="services">
	        <a href="">Snacks</a>
	        <ul class="dropdown">
	        <li><a href="/common/snackselectionform">ChooseSnack</a></li>
	        <li><a href="/admin/addsnackform">Insert Snack</a></li>
	        <li><a href="/admin/snacks">Snack List</a></li>
	        </ul>	
	        </li>
	        
	        <li class="services">
	        <a href="">Vendors</a>
	        <ul class="dropdown">
	        <li><a href="/admin/vendorinsertform">Insert Vendor</a></li>
	        <li><a href="/admin/vendors">Vendor List</a></li>
	        </ul>	
	        </li>
	        
	        <li class="services">
	        <a href="">Assignments</a>
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
    </c:if>
    
    <c:if test="${currentstatus != null}">
	<security:authorize access="isAuthenticated() and hasAuthority('User')">
	<%-- 
		<nav class="navbar" style="width:100%;justify-content:normal;">
	<img src="../img/dsquadlogo.png" alt="Dsquad"/>
	<span><i class="fa fa-user-alt" style="margin-right:5px;"></i><%= sharedData %></span>
	<ul class="nav-links" style="padding-left:29%;">
	<div class="menu">
	<li><a href="/common/profile">Profile</a></li>
	<li><a href="/common/snackselectionform">ChooseSnack</a></li>
	<li><a href="/logout">Logout</a></li>
	</div>
	</ul>
  </nav>
  --%>
	</security:authorize>
	</c:if>
	
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
    
    <c:if test="${currentstatus == null}">
    <security:authorize access="isAuthenticated()">
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
	</c:if>	
	

		
</body>
</html>