/**
 * 
 */

 let element = document.getElementById('myForm');

 if (element) {
	element.addEventListener('submit', function(event) {
		event.preventDefault();

		document.getElementById('nameError').textContent = '';
		document.getElementById('emailError').textContent = '';

		let name = document.getElementById('empname').value;
		let email = document.getElementById('email').value;

		let isValid = validateForm(name, email);

		if (isValid) {
			// Proceed with form submission
			console.log('Form is valid. Submitting...');
			// Add your form submission logic here
			element.submit();
		}
	});
} else {
	console.error("Element Not Found");
}

function validateForm(name, email) {
	let isValid = true;
	
	if (name.trim() === '') {
		document.getElementById('nameError').textContent = 'Name is required.';
		isValid = false;
	} else if (!isValidName(name)) {
		document.getElementById('nameError').textContent = "Alphabets and Spaces only allowed";
		isValid = false;
	}

	if (email.trim() === '') {
		document.getElementById('emailError').textContent = "Email is required";
		isValid = false;
	} else if (!isValidEmail(email)) {
		document.getElementById('emailError').textContent = "Invalid email Format";
		isValid = false;
	}
return isValid;
}

function isValidName(name) {
	var nameregex = new RegExp("^[A-Za-z\\s]+$");
	return nameregex.test(name);
}

function isValidEmail(email) {
	const emailregex = new RegExp(
		"^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})+$");
	return emailregex.test(email);
}