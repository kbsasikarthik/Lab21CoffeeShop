<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<main class="container">
	<form role="form" data-toggle="validator" class="form-group" action = "/admin-login" method = "post">
		<div class="form-group">	
		<div class="form-group row">
		    <label for="adminnamelabel">Admin Name</label>
		    <input class="form-control" type="text" name="adminname" required minlength="5"
		    		title="Minimum length is 5 characters">
		</div>
  		<div class="form-group row">
    		<label for="password">Password</label>
    		  <input type="password" class="form-control" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
    		  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
  		</div>
  		<button type="submit" class="btn btn-success" name="loginbtn">Login</button>
  		<a id = "home" href = "/" class="btn btn-primary"> Home</a>
  		</div>
  	</form>
 </main>
</body>
</html>