/**
 * 
 */

 let element = document.getElementById('snackinsertform');
 
 if(element)
 {
	 element.addEventListener('submit', function(event){
		event.preventDefault(); 
		
		document.getElementById('snacknameerror').textContent='';
		
		let snackname = document.getElementById("name").value;
		
		let isvalid = validateSnackName(snackname);
		
		if(isvalid)
		{
			console.log('Form is Valid.  Submitting');
			element.submit();
		}
	 });
 }
 else
 {
	 console.error("Element Not Found");
 }
 
 function validateSnackName(snackname)
 {
	 let isvalid = true;
	 
	 if(snackname.trim() === '')
	 {
		 document.getElementById('snacknameerror').textContent='Name is Required';
		 isvalid=false;
	 }
	 else if(!isValidName(snackname))
	 {
		 document.getElementById('snacknameerror').textContent='Alphabets and Spaces Only Allowed';
		 isvalid=false;
	 }
	 return isvalid;
 }
 
 function isValidName(snackname) {
	var nameregex = new RegExp("^[A-Za-z\\s]+$");
	return nameregex.test(snackname);
}