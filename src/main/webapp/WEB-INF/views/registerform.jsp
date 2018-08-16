<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
#pic { background-image: url("/back3.jpg");background-repeat:no-repeat; width: 800px; height: 1000px;}
#link{"font-family:Courier; font-size: 20px;"}
</style>
<form action = "/add-user" method = "post">
<p> First Name&emsp;&emsp;: <input name="firstname" type="text" /> </p>
<p> Last Name&emsp;&emsp;: <input name="lastname" type="text" /> </p>
<p> Email&emsp;&emsp;&emsp;&emsp;: <input name="email" type="email" /> </p>
<p> Phone Number : <input name="phone" type="tel" /> </p>
<p> Password &emsp;&emsp; : <input name="fname" type="password" /> </p>
<button>Register</button>
<h3><a id = "link" href = "/" font color:"red"> Home</a></h3>
<div id="pic">
</div>

</form>

</body>
</html>