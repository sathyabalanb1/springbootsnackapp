
$(function(){
  $('#shootdate').daterangepicker({
  locale:{
  format:'DD-MM-YYYY'
  }
  }
  );
});

function makeAjaxCall(url, method, data, datatype, ProcessData, type, successCallback, errorCallback) {
	$.ajax({
		url: url,
		type: method,
		data: data,
		dataType: datatype,
		processData: ProcessData,
		contentType: type,
		success: successCallback,
		error: errorCallback
	});
}

function validateResultform()
{
	var selectedDt = document.getElementById('shootdate').value;

	if (selectedDt == "") {
    document.getElementById("resultdateerror").innerHTML = "Please select the date.";
    return false;
  }
  return true;
}

function getSelectionDetails() {

var selectedDt = document.getElementById('shootdate').value;

console.log(selectedDt);

$.ajax({
		url: "/preparereport?input="+selectedDt,
		type: "GET",
		data: selectedDt,
		dataType: 'json',
		processData: false,
		contentType: "json",
		success: function(data) {
			console.log(1);
			console.log(data);
			console.log(data[0].dsuser.name);
			var sldate = selectedDt;
			const myArray = sldate.split(" - ");
            var modifieddate = myArray[1];	
			$('.snackwant').html('');  
            $('.oktable').before("<p class='snackwant' style='color:red'><b>List of Employees Who Want the Snack</b></p>");
            
            var e = $('<thead class="table-dark"  ><tr><th width="470px">ID</th><th width="470px">Employeename</th><th width="470px">ChoosenDate</th></tr></thead><tbody class="table-success">');
           $('#user').html('');  
           $('#user').append(e); 
           
           $('.snackdontwant').html('');  
           $('.notoktable').before("<p class='snackdontwant' style='color:red'><b>List of Employees Who Don't Want the Snack</b></p>");
           
           var d = $('<thead class="table-dark"  ><tr><th width="470px">ID</th><th width="470px">Employeename</th><th width="470px">ChoosenDate</th></tr></thead><tbody class="table-success">'); 
           $('#notokuser').html('');  
           $('#notokuser').append(d);
           
           poscount=0;
           negcount=0;
           
            for(i = 0; i < data.length; i++) {  
        student = data[i];
	    var e = $('<tr><td id = "userid" ></td><td id = "username"></td><td id = "selectiondate"></td></tr>');
        var d = $('<tr><td id = "notokuserid"></td><td id = "notokusername"></td><td id = "notokdate"></td></tr>');
        
        
        
        if(data[i].enabled == true)
        {
        $('#userid', e).html(data[i].dsuser.id);  
        $('#username', e).html(data[i].dsuser.name);
        $('#selectiondate', e).html(modifieddate);    
        $('#user').append(e);
        poscount++;  
        }
        else if(data[i].enabled == false)
        {
        $('#notokuserid', d).html(data[i].dsuser.id);  
        $('#notokusername', d).html(data[i].dsuser.name);  
        $('#notokdate', d).html(modifieddate);  
        $('#notokuser').append(d);
        negcount++; 
        }
        }
        if(poscount==0)
        {
        $('#user').html("<tr><td class='table-success' colspan='3'>No Records Found</td></tr>");  
        $('#user').append(e); 
        }
        if(negcount==0)
        {
        $('#notokuser').html("<tr><td class='table-success' colspan='3'>No Records Found</td></tr>");  
        $('#notokuser').append(d);
        }
        
        var e = $('</tbody>');
        $('#user').append(e); 
        
       
           
             			
			},
		error:function(xhr, status, error) {
				console.log("Error saving cinema: " + error);
			}
	});			
	
}

function getNoResponseDetails() {

var selectedDt = document.getElementById('shootdate').value;

console.log(selectedDt);

$.ajax({
		url: "/preparenoresponsereport?input="+selectedDt,
		type: "GET",
		data: selectedDt,
		dataType: 'json',
		processData: false,
		contentType: "json",
		success: function(data) {
				console.log(data);
			},
		error:function(xhr, status, error) {
				console.log("Error saving cinema: " + error);
			}
	});
}




