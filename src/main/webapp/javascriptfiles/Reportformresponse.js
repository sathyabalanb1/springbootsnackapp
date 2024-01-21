
$(function(){
    $("#shootdate").datepicker({ 
	dateFormat: 'dd-mm-yy',//check change
    changeMonth: true,
    changeYear: true });
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

	if (selectedDt == "") {
    document.getElementById("resultdateerror").innerHTML = "Please select the date.";
    return false;
  }
  
//console.log(selectedDt);

$.ajax({
		url: "/preparereport?input="+selectedDt,
		type: "GET",
		data: selectedDt,
		dataType: 'json',
		processData: false,
		contentType: "json",
		success: function(data) {
		//	console.log(data.length);
			//console.log(data[0].dsuser.name);
			console.log(data);
			var sldate = selectedDt;
		//	const myArray = sldate.split(" - ");
        //    var modifieddate = myArray[1];	
			$('.snackwant').html('');  
            $('.oktable').before("<p class='snackwant' style='color:red'><b>List of Employees Who Want the Snack</b></p>");
            
           var e = $('<thead class="table-dark"  ><tr><th width="470px" scope="col">ID</th><th width="470px" scope="col">Employeename</th><th width="470px" scope="col">ChoosenDate</th></tr></thead><tbody>');
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
        $('#selectiondate', e).html(selectedDt);    
        $('#user').append(e);
        poscount++;  
        }
        else if(data[i].enabled == false)
        {
        $('#notokuserid', d).html(data[i].dsuser.id);  
        $('#notokusername', d).html(data[i].dsuser.name);  
        $('#notokdate', d).html(selectedDt);  
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
        
       $('.selectioncount').html('');  
              
        $('.countinfotable').before("<p class='selectioncount' style='color:red'><b>Count Information Based on the Category</b></p>");
	var resultcount = '<thead class="table-dark"><tr><th width="470px">Sl.No</th><th width="470px">Category</th><th width="470px">Count</th></tr></thead><tbody class="table-success">';
	resultcount += '<tr><td id = "slno"></td><td id = "poscategory"></td><td id = "positivevaluecount"></td></tr>';
	resultcount += '<tr><td>1</td><td>Number of Employeess Who Want the Snack</td><td>'+poscount+'</td></tr>';
	resultcount += '<tr><td>2</td><td>Number of Employeess Who Dont Want the Snack</td><td>'+negcount+'</td></tr></tbody></table>';

	$('#resultuser').html(resultcount);
           
             			
			},
		error:function(xhr, status, error) {
				console.log("Error saving cinema: " + error);
			}
	});			
	
}

function getNoResponseDetails() {

var selectedDt = document.getElementById('shootdate').value;

	if (selectedDt == "") {
    document.getElementById("resultdateerror").innerHTML = "Please select the date.";
    return false;
  }
//console.log(selectedDt);

$.ajax({
		url: "/preparenoresponsereport?input="+selectedDt,
		type: "GET",
		data: selectedDt,
		dataType: 'json',
		processData: false,
		contentType: "json",
		success: function(data) {
				//console.log("qwertasdfghbnm");
				//console.log(data);
		    var sldate = selectedDt;
				
		$('.snacknoresponse').html('');  
        $('.noresponsetable').before("<p class='snacknoresponse' style='color:red'><b>List of Employees Who are All Not Responded</b></p>");
        
        var f = $('<thead class="table-dark"  ><tr><th width="470px">ID</th><th width="470px">Employeename</th><th width="470px">NotrespondedDate</th></tr></thead><tbody class="table-success">'); 
        $('#noresponseuser').html('');  
        $('#noresponseuser').append(f);
        
        if(data[0].name != null)
        {
        for(i = 0; i < data.length; i++) {  
		

        var f = $('<tr><td id = "noresponseuserid"></td><td id = "noresponseusername"></td><td id="noresponsedate"></td></tr>');
        
        
        $('#noresponseuserid', f).html(data[i].id);  
        $('#noresponseusername', f).html(data[i].name); 
        $('#noresponsedate', f).html(selectedDt);   
        $('#noresponseuser').append(f);  
                    
        }
        }
        if(data[0].name == null)
        {
        $('#noresponseuser').html("<tr><td class='table-success' colspan='3'>No Records Found</td></tr>");  
        $('#noresponseuser').append(f);
        data=[];
        }
        
        var resultcount = $('<tbody>');
        var rcount = $('<tr><td id = "slno"></td><td id = "noresponsecategory"></td><td id = "noresponsevalue"></td></tr>');
        $('#noresponsecategory', rcount).html("Number of Employeess Who Have not Responded for the Snack");
        $('#slno', rcount).html(3);  
        $('#noresponsevalue', rcount).html(data.length);
        var resultcount = $('</tbody>');
        $('#resultuser').append(rcount);

        
			},
		error:function(xhr, status, error) {
				console.log("Error saving cinema: " + error);
			}
	});
}




