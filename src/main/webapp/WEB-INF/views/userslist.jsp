<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Foods</title>
<!-- Link the bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<main class="container">
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
	<h1 class="navbar-brand"><strong>Welcome to SK Coffee shop</strong></h1>
		<a class="btn btn-info" href="/item">Back</a>
		<a class="btn btn-warning" href="/">Logout</a>
		
		
	</nav>
	<h1>List of Users</h1>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone Number</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td >${user.firstname}</td>
				<td >${user.lastname}</td>
				<td >${user.email}</td>
				<td >${user.phone}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	

		
</body>
</html>