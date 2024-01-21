<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="../css/topnavigation.css" rel="stylesheet"/>
<link href="../css/footer.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title>Report Page</title>
</head>
<body>
<%@include file="../headerfooter/header.jsp"%>
 <!--  
<label for="shootdate">Enter the Date:</label><br>
<input required type="text" id="shootdate" name="shootdate" id="shootdate" title="Choose your desired date" autocomplete="off" />

<button id="loadreport" class="btn btn-success" onclick="getSelectionDetails(),getNoResponseDetails()">Submit</button>
<span class="error" id="resultdateerror" style="color:red;"></span>
-->
  
<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="mb-0">Report Form</h4>
					</div>
					<div class="card-body">
					<div class="mb-3">
						<label for="shootdate" class="form-label">Enter the Date:</label>							
<input required type="text" id="shootdate" name="shootdate"class="form-control" id="shootdate" title="Choose your desired date" autocomplete="off"/>
<button id="loadreport" class="btn btn-success" onclick="getSelectionDetails(),getNoResponseDetails()">Submit</button>
<span class="error" id="resultdateerror" style="color:red;"></span>							
                     </div>
							
					</div>
				</div>
			</div>
		</div>
	</div>
	
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
<%@include file="../headerfooter/footer.jsp"%>
      
</body>
<script src="../javascriptfiles/Reportformresponse.js" type="text/javascript"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>


</html>