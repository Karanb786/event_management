var count = 0;
window.addEventListener('load', () => {
	arr = [{
        "Name": "Peter",
        "Job": "Programmer"
      },
      {
        "Name": "John",
        "Job": "Programmer"
      },
      {
        "Name": "Kevin",
        "Job": "Scientist"
      },
    ];

	 $.each(arr, function(i) {
      var templateString =
        '<div class="col-sm-4 card mb-2 box-shadow">    <img class="card-img-top" src="http://safarset.com/wp-content/uploads/2019/05/IMG-20190423-WA0029.jpeg" alt="Card image cap">      <div class="card-body p-0">  <h5>' +
        arr[i].Name + '</h5> </p></div> </div>';
      $('#test').append(templateString);
    })
	Object.keys(localStorage).forEach(function(key){
   console.log(localStorage.getItem(key));
   
    const eventName = localStorage.getItem('eventname');
    const eventDate = localStorage.getItem('date');
    const eventTime = localStorage.getItem('time');
    const eventLocation = localStorage.getItem('location');
    const eventDesc = localStorage.getItem('description');
    const eventSeatReamining = localStorage.getItem('quantity');
    
    alert(eventName);
    
    document.getElementById('eventname-filler').innerHTML = eventName;
    document.getElementById('eventDate-filler').innerHTML = eventDate;
    document.getElementById('eventTime-filler').innerHTML = eventTime;
    document.getElementById('eventLocation-filler').innerHTML = eventLocation;
    document.getElementById('eventDescp-filler').innerHTML = eventDesc;
    document.getElementById('eventCount-filler').innerHTML = eventSeatReamining;
    
	});

        
   

  

})