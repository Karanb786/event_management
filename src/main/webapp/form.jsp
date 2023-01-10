<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<TITLE>Invitation</TITLE>
<meta charset="UTF-8">


<link rel="stylesheet" href="style.css">

<script type="text/javascript" src="validator.js"> </script>
</head>

<body>
<h1>Create invitation</h1>

 
<form name="myForm"  method="post" onSubmit = "formValidation()" id ="eventDetails">

Event Name:
<input type="text" name = "eventname" id = "eventname">

<lable for="date">Date:</lable>
<input type="date" name = "date" id = "date">

<lable for="time">Time:</lable>
<input type="time" name = "time" id="time">

<lable for ="location">Location:</lable>
<input type="text" name = "location" placeholder="Please describe location" id ="location">

<lable for="description">Description of event:</lable>
<textarea rows="10" cols="10" name = "description" id="description" placeholder="Please describe event"></textarea>

<label for="quantity">How many people?:</label>
<input type="number" id="quantity" name="quantity">
<br>

<lable for="username">Username:</lable>
<input type="text" name = "username" id = "username">

<lable for="password">Password:</lable>
<input type="password" name = "password" id = "password">

<lable for=submit></lable>
<input type="submit" value="Submit" id = "submit" onSubmit="validator" onclick="saveData()" ></input>



</form>

<lable for=submit></lable>
<input type="submit" value="See events" id = "displayEvent" onclick="location.href = 'eventList'"></input>

<lable for=submit></lable>
<input type="submit" value="Admin events" id = "adminEvent" onclick="location.href = 'adminList.jsp'"></input>

<lable for="reset"></lable>
<input type="reset" value="Reset" onSubmit="form" name="resetbutton">





</body>
</html>