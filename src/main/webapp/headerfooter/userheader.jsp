<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
	<%@ page import="javax.servlet.http.HttpSession" %>
	
<!DOCTYPE html>
<html>
<head>
<link href="../css/topnavigation.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet"
	href="https://site-assets.fontawesome.com/releases/v6.1.1/css/all.css">
<style>

</style>

<meta charset="UTF-8">
<title>User Header</title>
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
<security:authorize access="isAuthenticated() and hasAuthority('User')">
		<nav class="navbar" style="width:100%;justify-content:normal;">
	<img src="../img/dsquadlogo.png" alt="Dsquad"/>
	<span><i class="fa fa-user-alt" style="margin-right:5px;margin-left:10px;"></i><%= sharedData %></span>
	<ul class="nav-links" style="padding-left:55%;">
	<div class="menu">
	<li><a href="/common/profile">Profile</a></li>
		<li><a href="/common/snackselectionform">ChooseSnack</a></li>
			<li><a href="/logout">Logout</a></li>
	</div>
	</ul>
  </nav>
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

</body>
</html>