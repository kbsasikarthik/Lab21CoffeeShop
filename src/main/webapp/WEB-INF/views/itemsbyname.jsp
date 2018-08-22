<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css" />
<title>Insert title here</title>
</head>
<body>

<c:forEach var="item" items="${items}">
	<p>ID : ${item.id }</p>
	<p> Name : 	${item.name}</p>
	<p>Category: ${item.category}</p>
	<p>Description:	${item.description}</p>
</c:forEach>
<p><a href="/" class="btn btn-primary">Home</a></p>
</body>
</html>