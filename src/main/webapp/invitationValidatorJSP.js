/**
 * 
 */
 function validateForm() {
	//validations for the location field - cannot be empty
	var locationInput = document.forms["EventFormPage"]["location"].value;
	if (!locationInput) {
		alert("Please provide location for the event");
		return false;
	}

	//validations for the description field - cannot be empty and minimum 50 characters.
	var descInput = document.forms["EventFormPage"]["desc"].value;
	if (descInput == '') {
		alert("Description is not provided. It is required");
		return false;
	}
	if (descInput.length < 20) {
		alert("Description should have minimum 20 characters!");
		return false;
	}

	//validations for the name field - cannot be empty and only alphabets
	var nameInput = document.forms["EventFormPage"]["eventname"].value;
	if (nameInput == '') {
		alert("Please Enter your Name. It is required");
		return false;
	}
	var regex = new RegExp("^[a-zA-Z ]+$");
	if (!regex.test(nameInput)) {
		alert("Error: Name contains invalid characters!");
		return false;
	}

	//validations for the date field - cannot be empty and alteast one day after today
	var dateInput = document.forms["EventFormPage"]["date"].value;
	if (!dateInput) {
		alert("Please Enter Date for the event!");
		return false;
	}

	let today = new Date().toISOString().slice(0, 10)
	if (dateInput < today) {
		alert("Please Enter Date atleast one day after today!");
		return false;
	}

}
