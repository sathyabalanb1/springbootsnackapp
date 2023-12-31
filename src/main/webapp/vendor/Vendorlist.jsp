<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor List</title>
</head>
<%@include file="../headerfooter/header.jsp"%>
<body>
<table border="1">
<thead>
<tr>
<td>Sl. No</td>
<td>Vendor Name</td>
<td>Location</td>
<td>Mobile Number</td>
<td>Landline Number</td>
<td>Email</td>
<td>Edit Vendor</td>
<td>Delete Vendor</td>
</tr>
</thead>
<tbody>
<c:forEach var="vendorentry" items="${vendors}" varStatus="loop">
<tr>
<td>${loop.index+1}</td>
<td>${vendorentry.vendorname}</td>
<td>${vendorentry.city}</td>
<td>${vendorentry.mobilenumber}</td>
<td>${vendorentry.landlinenumber}</td>
<td>${vendorentry.email}</td>
<!-- <td><a href="/${vendorentry.id}/54/skabsk">Edit</a></td> -->
<td><a href="/admin/updatevendorform?vid=${vendorentry.id}">Edit</a></td>

<td><a href="/admin/deletevendor?vid=${vendorentry.id}" onclick="return confirm('Are you sure to delete this Vendor?')">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>