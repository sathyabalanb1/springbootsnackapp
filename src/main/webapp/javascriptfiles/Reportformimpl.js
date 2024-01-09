
function findCountinfo() {
var selectedDt = document.getElementById('resultdate').value;
  if (selectedDt == "") {
    document.getElementById("resultdateerror").innerHTML = "Please select the date.";
    return false;
  }
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
	  alert(xhttp.responseType);
    document.getElementById("selectionreport").innerHTML = "hi"
  }
  xhttp.open("GET","/preparereport?reportdate="+selectedDt);
  xhttp.getResponseHeader("Content-type", "application/json"); 
  xhttp.send();
  
}
