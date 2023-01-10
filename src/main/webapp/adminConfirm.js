let username_ev;
let password;
let bar;
let successLogin = false;
class WorkoutTracker {
  static LOCAL_STORAGE_DATA_KEY = "events";
  static localstorage_eventConfoirm	= "userConfirmation";
	
  constructor(root) {
      this.root = root;
      this.root.insertAdjacentHTML("afterbegin", WorkoutTracker.html());
      this.entries = [];
      this.userAttend = [];
      username_ev = prompt('Enter Username');
  		password = prompt("Enter password");
  		bar = confirm(username_ev+', confirm your username');
  		let x=0
  		var userDetails = JSON.parse(window.localStorage.getItem('events'));
  		for(x in userDetails){
			if(userDetails[x].username == username_ev && userDetails[x].password==password){
			successLogin = true;
			alert("Login successfull");
			sessionStorage.setItem("userName",username_ev);
		break;
		}
		}

      this.loadEntries();
      this.updateView();
  }
  


  static html() {
      return `
          <table class="tracker" id="disp_table">
              <thead>
                  <tr class = "selected">
                      <th>Event</th>
                      <th>Date</th>
                      <th>Time</th>
                      <th>Quantity</th>
                      <th>Made by</th>
                      <th>Delete</th>
                  </tr>
              </thead>
              <tbody class="tracker__entries"></tbody>
          </table>
      `;
  }

  static rowHtml() {
      return `
          <tr class="tracker__row">
              <td>
                  <input type="text" class="event_name" readonly>
              </td>
              <td>
                  <input type ="text" class="Date_tracker" readonly>
              </td>
              
              <td>
              		<input type="text" class="event_time" readonly>
   
              </td>
              <td>
                  <input type="text" class="quantity_event" readonly>
              </td>
              <td>
                  <input type="text" class="username_present" readonly>
              </td>
              <td>
              	  <button type="button" class="tracker__button tracker__delete">&times;</button>

              </td>
          </tr>
      `;
  }
  

  storeItems(){
	alert("hellpo");
}
 

  loadEntries() {
      this.entries = JSON.parse(localStorage.getItem(WorkoutTracker.LOCAL_STORAGE_DATA_KEY) || "[]");
  }

  saveEntries() {
	 localStorage.setItem(WorkoutTracker.LOCAL_STORAGE_DATA_KEY, JSON.stringify(this.entries));
      //localStorage.setItem(WorkoutTracker.LOCAL_STORAGE_DATA_KEY, JSON.stringify(this.entries));
  }

  updateView() {
      const tableBody = this.root.querySelector(".tracker__entries");
      const addRow = data => {
          const template = document.createElement("template");
          let row = null;

          template.innerHTML = WorkoutTracker.rowHtml().trim();
          row = template.content.firstElementChild;

		var l =data.time;
		let is_dupli = false;
	//	var userConfirmation = window.localStorage.getItem("userConfirmation");
		var userConfirmation = JSON.parse(window.localStorage.getItem('userConfirmation'));
		var username = data.username;
		document.getElementById("userName_head").innerHTML = username_ev;

		if(successLogin){
			if(username_ev == data.username){
			
         row.querySelector(".event_name").value = data.eventname;
         row.querySelector(".Date_tracker").value = data.date;
         row.querySelector(".event_time").value = l;
		 row.querySelector(".quantity_event").value = data.quantioty;
		 row.querySelector(".username_present").value = username;
		 tableBody.appendChild(row);
		
          }}
          
               row.querySelector(".tracker__delete").addEventListener("click", () => {
              this.deleteEntry(data);
          });
		 
      };
     

      tableBody.querySelectorAll(".tracker__row").forEach(row => {
          row.remove();
      });
      
      this.entries.forEach(data => addRow(data));
      
      
  }

  addEntry(data) {
      this.entries.push(data);
      this.saveEntries();
      this.updateView();
  }
  


  deleteEntry(dataToDelete) {
      this.entries = this.entries.filter(data => data !== dataToDelete);
      this.saveEntries();
      this.updateView();
  }
  
}
document.getElementById("submit").onclick = function () {
        sessionStorage.setItem("userName",username_ev);
        location.href = "userEvents.jsp";
        alert("Done");
    };

window.addEventListener("load", (event) => {
  
  
});



const app = document.getElementById("app");

const wt = new WorkoutTracker(app);

window.wt = wt;