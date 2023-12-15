/**
 * 
 */

 let element = document.getElementById('vendorinsertform');

 if(element)
 {
	 element.addEventListener('submit', function(event){
		event.preventDefault(); 
		
		document.getElementById('vendornameerror').textContent='';
		
		let vendorname = document.getElementById("vendorname").value;
		
		let cityname = document.getElementById("city").value;
		
		let statename = document.getElementById("state").value;
		
		let countryname = document.getElementById("country").value;
		
		let pincode = document.getElementById("pincode").value;
		
		let mobilenumber = document.getElementById("mobilenumber").value;
		
		let landlinenumber = document.getElementById("landlinenumber").value;
		
		let email = document.getElementById("email").value;




		
		let isvalidVendor = validateVendorName(vendorname);
		
		let isvalidCity = validateCityName(cityname);
		
		let isvalidState = validateStateName(statename);
		
		let isvalidCountry = validateCountryName(countryname);
		
		let isvalidPincode = validatePincode(pincode);
		
		let isvalidMobilenumber = validateMobileNumber(mobilenumber);
		
		let isvalidLandlinenumber = validateLandlineNumber(landlinenumber);
		
		let isvalidEmail = validateEmail(email);




		
		if(isvalidVendor && isvalidCity && isvalidState && isvalidCountry && isvalidPincode && isvalidMobilenumber && isvalidLandlinenumber && isvalidEmail)
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
 function validateVendorName(vendorname)
 {
	 let isvalid = true;
	 
	 if(vendorname.trim() === '')
	 {
		 document.getElementById('vendornameerror').textContent='Name is Required';
		 isvalid=false;
	 }
	 else if(!isValidName(vendorname))
	 {
		 document.getElementById('vendornameerror').textContent='Alphabets and Spaces Only Allowed';
		 isvalid=false;
	 }
	 return isvalid;
 }
 function isValidName(vendorname) {
	var nameregex = new RegExp("^[A-Za-z\\s]+$");
	return nameregex.test(vendorname);
}
function validateCityName(cityname)
 {
	 let isvalid = true;
	 
	 if(cityname.trim() === '')
	 {
		 document.getElementById('citynameerror').textContent='Name is Required';
		 isvalid=false;
	 }
	 else if(!isValidName(cityname))
	 {
		 document.getElementById('citynameerror').textContent='Alphabets and Spaces Only Allowed';
		 isvalid=false;
	 }
	 return isvalid;
 }
 function validateStateName(statename)
 {
	 let isvalid = true;
	 
	 if(statename.trim() === '')
	 {
		 document.getElementById('statenameerror').textContent='Name is Required';
		 isvalid=false;
	 }
	 else if(!isValidName(statename))
	 {
		 document.getElementById('statenameerror').textContent='Alphabets and Spaces Only Allowed';
		 isvalid=false;
	 }
	 return isvalid;
 }
 function validateCountryName(countryname)
 {
	 let isvalid = true;
	 
	 if(countryname.trim() === '')
	 {
		 document.getElementById('countrynameerror').textContent='Name is Required';
		 isvalid=false;
	 }
	 else if(!isValidName(countryname))
	 {
		 document.getElementById('countrynameerror').textContent='Alphabets and Spaces Only Allowed';
		 isvalid=false;
	 }
	 return isvalid;
 }
 function validatePincode(pincode)
 {
	 	 let isvalid = true;
	 	 
	 if(pincode.trim() === '')
	 {
		 document.getElementById('pincodeerror').textContent='Pincode is Required';
		 isvalid=false;
	 }
	 else if(!isValidPincode(pincode))
	 {
		 document.getElementById('pincodeerror').textContent='Pincode Must be with six numeral digits';
		 isvalid=false;
	 }
	 return isvalid;
 }
 function isValidPincode(pincode)
 {
	 const pincoderegex = new RegExp(
		"(^[1-9]{1}[0-9]{5}$|[1-9]{1}[0-9]{2}\\s[0-9]{3})");
	let output = pincoderegex.test(pincode);
	return output;
}
function validateMobileNumber(mobilenumber)
 {
	 let isvalid = true;
	 	 
	 if(mobilenumber.trim() === '')
	 {
		 document.getElementById('mobilenumbererror').textContent='Mobile Number is Required';
		 isvalid=false;
	 }
	 else if(!isValidMobileNumber(mobilenumber))
	 {
		 document.getElementById('mobilenumbererror').textContent='Please Enter a Valid Mobile Number';
		 isvalid=false;
	 }
	 return isvalid;
 }
 function isValidMobileNumber(mobilenumber)
 {
	/* const mobilenumberregex = new RegExp(
			"/^([+]\d{2})?\d{10}$/");*/
		//const mobilenumberregex = new RegExp("^([+]\\d{2})?\\d{10}")
		const mobilenumberregex = new RegExp("^([+]\\d{2})?\\d{10}$");

	let ans = mobilenumberregex.test(mobilenumber);
	return ans;
}

function validateLandlineNumber(landlinenumber)
 {
	 	 let isvalid = true;
	 	 
	 if(landlinenumber.trim() === '')
	 {
		 document.getElementById('landlinenumbererror').textContent='Landline Number is Required';
		 isvalid=false;
	 }
	 else if(!isValidLandlineNumber(landlinenumber))
	 {
		 document.getElementById('landlinenumbererror').textContent='Please Enter a Valid Landline Number';
		 isvalid=false;
	 }
	 return isvalid;
 }
 function isValidLandlineNumber(landlinenumber)
 {
	 const landlinenumberregex = new RegExp(
		"^044-\\d{8}$");
		
//	^\\d{3}-\\d{8}$
	return landlinenumberregex.test(landlinenumber);
}
function validateEmail(email)
 {
	 	 let isvalid = true;
	 	 
	 if (email.trim() === '') {
		document.getElementById('emailerror').textContent = "Email is required";
		isvalid = false;
	} else if (!isValidEmail(email)) {
		document.getElementById('emailerror').textContent = "Invalid email Format";
		isvalid = false;
	}
	 return isvalid;
 }
 function isValidEmail(email) {
	const emailregex = new RegExp(
		"^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})+$");
	return emailregex.test(email);
}

