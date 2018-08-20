<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>

<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/journal/bootstrap.min.css" >
<link rel="stylesheet" href="/style.css" />
<title>Home page for the application</title>

</head>
<body >
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  <!-- Navbar content -->
  <h1 class="navbar-brand"><strong>Welcome to SK Coffee shop</strong></h1>
  <form class="form-inline">
	<a id = "register" href = "/register-form" class="btn btn-primary">Register</a>
  	<a id = "listproducts" href = "/product" class="btn btn-primary">List products</a>
  </form>
</nav>
</body>
</html>