let username_ev;
let bar;
class WorkoutTracker {
  static LOCAL_STORAGE_DATA_KEY = "events";
  static localstorage_eventConfoirm	= "userConfirmation";

  constructor(root) {
      this.root = root;
      this.root.insertAdjacentHTML("afterbegin", WorkoutTracker.html());
      this.entries = [];
      this.userAttend = [];

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
                      <th>Confirm event</th>
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
     
                  <input type="checkbox" class="storeDetails">
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
	 sessionStorage.setItem(userAttendance.LOCAL_STORAGE_DATA_KEY, JSON.stringify(this.entries));
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
		
		
         row.querySelector(".event_name").value = data.eventname;
         row.querySelector(".Date_tracker").value = data.date;
         row.querySelector(".event_time").value = l;
		 row.querySelector(".quantity_event").value = data.quantioty;
		 row.querySelector(".username_present").value = username;
		 tableBody.appendChild(row);
		 
		
		  row.querySelector(".storeDetails").addEventListener("click", () => {
              if(username == username_ev){
				alert(username_ev+", organiser cannot confirm attendance!")
				}else{
				let attend = new Array();
				attend = JSON.parse(localStorage.getItem("userConfirmation"))?JSON.parse(localStorage.getItem("userConfirmation")):[]
				attend.push({
					"userName":username_ev,
					"eventName": data.eventname
				})
				let x=0;
				for(x in userConfirmation){
					if(username_ev==userConfirmation[x].userName && data.eventname==userConfirmation[x].eventName){
						is_dupli =  true;
					}
				}
				if(is_dupli){
					alert("User already confirmed for this event!");
				}else{
				data.quantioty = data.quantioty -1;
				alert("Hi, "+username_ev+" event "+data.eventname+" is confirmed");
				localStorage.setItem("userConfirmation",JSON.stringify(attend));
				is_dupli =  true;
				this.updateView();
				}
				}
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
  username_ev = prompt('Enter Username');
		bar = confirm(username_ev+', confirm your username.');
});



const app = document.getElementById("app");

const wt = new WorkoutTracker(app);

window.wt = wt;