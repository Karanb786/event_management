function formValidation() {
	var locationInput = document.forms["myForm"]["location"].value;
	if (!locationInput) {
		alert("Location cannot be empty");
		return false;
	}
	var descInput = document.forms["myForm"]["description"].value;
	if (descInput == '') {
		alert("Description cannot be empty");
		return false;
	}

	var nameInput = document.forms["myForm"]["eventname"].value;
	if (nameInput == '') {
		alert("Name cannot be empty");
		return false;
	}
	var dateInput = document.forms["myForm"]["date"].value;
	if (!dateInput) {
		alert("Date cannot be empty");
		return false;
	}

	let today = new Date().toISOString().slice(0, 10)
	if (dateInput < today) {
		alert("Please Enter Date atleast one day after today!");
		return false;
	}
	

	  	

	  	


}



function saveData(){
	
	let eventname = document.getElementById("eventname").value
	let description = document.getElementById("description").value;
	let date = document.getElementById("date").value;
	let location = document.getElementById("location").value;
	let time = document.getElementById("time").value;
	let quantity = document.getElementById("quantity").value;
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	
	let event_record = new Array();
	event_record = JSON.parse(localStorage.getItem("events"))?JSON.parse(localStorage.getItem("events")):[]
	
		event_record.push({
			"eventname":eventname,
			"description": description,
			"date": date,
			"location": location,
			"time":	time,
			"quantioty":quantity,
			"username": username,
			"password": password
		})
		localStorage.setItem("events",JSON.stringify(event_record));
		alert("Event saved");
		
		
		
		
	


}

	
