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
		<a id = "register" href = "/register-form" class="btn btn-primary">Register</a>
		
	</nav>
	<h1>List of Products</h1>
		<form class="form-inline" action="/itemsbyname" autocomplete="off">
		<label class="sr-only" for="inlineFormInputName2">Name</label>
		<input type="text" value="${name}"class="form-control mb-2 mr-sm-2" id="name" name="name" placeholder="name">
		<button type="submit" class="btn btn-primary mb-2 mr-2">Search</button>
		<c:if test="${not empty name}">
		  	<a href="/" class="btn btn-secondary mb-2 mr-2">Clear</a>
		</c:if>
	</form>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th><th>Item</th><th>Category</th><th>Price</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${items}">
			<tr>
				<td>${item.id}</td>
				<td ><a href="/items/${item.id}">${item.name}</a></td>
				<td >${item.category}</td>
				<td >${item.price}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	

		
</body>
</html>