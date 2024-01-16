<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<meta charset="UTF-8">
<title>Report Page</title>
</head>
<body>
<%@include file="../headerfooter/header.jsp"%>
<label for="shootdate">Enter the Date:</label><br>
<input required type="text" id="shootdate" name="shootdate" id="shootdate" title="Choose your desired date" />

<button id="loadreport" class="btn btn-success" onclick="getSelectionDetails(),getNoResponseDetails()">Submit</button>
<span class="error" id="resultdateerror" style="color:red;"></span>

<table id="user" class="oktable" border="1">  
</table> 
<br><br>

<table id="notokuser" class="notoktable" border="1">  
</table>
<br>
<table id="noresponseuser" class="noresponsetable" border="1">  
</table>  
<br><br>
<table id="resultuser" class="countinfotable" border="1">  
</table>      
</body>
<script src="../javascriptfiles/Reportformresponse.js" type="text/javascript"></script>

</html>