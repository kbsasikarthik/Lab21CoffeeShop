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
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
<!-- Or in this case, a variation theme... -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<!-- With boostrap, pages should generally be surrounded with a container element. -->
	<main class="container">
		<h1>
			Types of Coffee
		</h1>
		
		<form class="form-inline" action="/product" autocomplete="off">
		  <label class="sr-only" for="inlineFormInputName2">Category</label>
		  <%-- prefill a form input using the value attribute. --%>
		  <input type="text" value="${category}" class="form-control mb-2 mr-sm-2" id="category" name="category" placeholder="Category">
		
		  <button type="submit" class="btn btn-primary mb-2 mr-2">Search</button>
		  <c:if test="${not empty category}">
		    <%-- c:if determines whether its contents should show or not --%>
		  	<a href="/product" class="btn btn-secondary mb-2">Clear</a>
	  	  </c:if>
		</form>
		
		<table class="table" >
			<thead>
			<tr>
				<th>ID</th><th>Product Name</th><th>Category</th><th>Description</th><th>Price (per lb)</th><!-- <th>Select</th><th>Quantity</th>-->
			</tr>
			</thead>
			<tbody>
			<%-- c:forEach is loops through the items and repeats the content for each one.
			     Think of this as:   for (Food food : foods) { ... }
			--%>
			<c:forEach items="${products}" var="product">
				<tr >
					<%-- Access properties of the java bean using simple . notation.
					     This actually calls the getters behind the scenes. --%>
				<td>${product.id }</td><td>${product.name}</td><td>${product.category}</td><td><div style = "width:400px; word-wrap: break-word"> ${product.description}</div></td><td>$${product.price}</td>
				<!-- <td class="chk" align="center"><input type="checkbox"></td><td><input type="number" style = "width:40px;" min=0 max=5 step=1 value=0></td>-->
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<!--  <a class="btn btn-primary" href="/addtocart">Add to cart</a>-->
		<a id = "link" href = "/" class="btn btn-primary"><img src="/home.jpg" style="height:18px"/> Home</a>	</main>
</body>
</html>