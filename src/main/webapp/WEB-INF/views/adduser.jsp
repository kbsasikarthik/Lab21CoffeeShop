<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<style type="text/css">
#pic { background-image: url("/back3.jpg");background-repeat:no-repeat; width: 800px; height: 1000px;}
</style>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/journal/bootstrap.min.css" >

<title>Insert title here</title>
</head>
<body>
<h1>Hello <b><i>${user.firstname } </i></b>!</h1>
<h2>Registration is complete. Please return home. </h2>
<a id = "home" href = "/" class="btn btn-primary"><img src="/home.jpg" style="height:18px"/> Home</a>
<a id = "back" href = "/register-form" class="btn btn-primary">Back</a>
<div id="pic">
</div>


</body>
</html>