<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/journal/bootstrap.min.css" >

<link rel="stylesheet" href="/style.css" /> 
<title>Shows the registration form for a new user</title>
</head>
<body>
<main class="container">

<form role="form" data-toggle="validator" class="form-group" action = "/add-user" method = "post">
	<div class="form-group">	
		<div class="form-group row">
		    <label for="firstnamelabel">First Name</label>
		    <input class="form-control" type="text" name="firstname" required minlength="2"
		    		title="Minimum length is 2 characters">
		</div>
		<div class="form-group row">
		    <label for="lastnamelabel">Last Name</label>
		    <input class="form-control" type="text" name="lastname" required minlength="2"
		    		title="Minimum length is 2 characters">
		</div>
		<div class="form-group row">
		    <label for="phonelabel">Phone Number</label>
		    <input class="form-control" name="phone" type="tel"  placeholder="123-456-7890" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"  
		    		title ="Format xxx-xxx-xxxx" required>
		</div>
  		<div class="form-group row">  
  		 	<label for="emaillabel">Email address</label>
    		<input type="email" class="form-control" name="email" aria-describedby="emailHelp"
    				title ="Please enter a valid email address">
    		<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
 		</div>
  		<div class="form-group row">
    		<label for="password1label">Password</label>
    		  <input type="password" class="form-control" name="password1" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
    		  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
    		<!--  <input type="password"  name="password1">-->
  		</div>
  		
  		<div class="form-group row">
    		<label for="password2label">Confirm Password</label>
			<input type="password" class="form-control" name="password2" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
    		  title="Please re-enter password." required>
    	</div>		  
    	<c:if test="${password1 eq password2}">
		    <%-- c:if determines whether its contents should show or not --%>
  			<button type="submit" class="btn btn-primary" name="submitbtn" ${btnstatus}>Register</button>
	 	  </c:if>
   
  		
		
		<a id = "link" href = "/" class="btn btn-primary"><img src="/home.jpg" style="height:18px"/> Home</a>

	</div>

</form>
</main>
</body>
</html>