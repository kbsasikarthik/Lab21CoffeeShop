<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Items</title>
<!-- Link the bootstrap CSS -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
<!-- Or in this case, a variation theme... -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<!-- With boostrap, pages should generally be surrounded with a container element. -->
	<main class="container">
		<h1>Items</h1>
		<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		
			<a class="btn btn-secondary" href="/item/create">Add</a>
			<a class="btn btn-info" href="/users">List Users</a>
			<a class="btn btn-warning" href="/">Logout</a>
		</nav>
		<table class="table">
			<thead>
			<tr>
				<th>Item</th><th>Category</th><th>Description</th><th>Price</th><th>Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<%-- Access properties of the java bean using simple . notation.
					     This actually calls the getters behind the scenes. --%>
					<td>${item.name}</td><td>${item.category}</td><td>${item.description}</td><td>${item.price}</td>
					<form action="/Config?pg=FIBiller&amp; cmd=delete">
					<td>
						<a href="/item/${ item.id }/update" class="btn btn-warning btn-sm">Edit</a>
						<a href="/item/${ item.id }/delete" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete?')">Delete</a>
					</td>
					</form>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<form class="form-inline" action="/item" autocomplete="off">
		  <label class="sr-only" for="keyword">Name</label>
		  <input type="text" value="${param.name}" class="form-control mb-2 mr-sm-2" id="name" name="name" placeholder="name">
		  
		  <label class="sr-only" for="category">Category</label>
		  <select class="form-control mb-2 mr-sm-2" id="category" name="category">
		  	<option value="">Category</option>
		  	<c:forEach items="${ categories }" var="cat">
		  		<option <c:if test="${ cat eq param.category }">selected</c:if>>${ cat }</option>
		  	</c:forEach>
		  </select>
		
		  <button type="submit" class="btn btn-primary mb-2 mr-2">Search</button>
		  <c:if test="${not empty param.keyword or not empty param.category}">
		    <%-- c:if determines whether its contents should show or not --%>
		  	<a href="/item" class="btn btn-secondary mb-2">Clear</a>
	  	  </c:if>
		</form>
		
	</main>
</body>
</html>