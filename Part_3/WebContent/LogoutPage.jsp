<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="logout.css">
<meta charset="ISO-8859-1">
<title>Log Out</title>
</head>
<body>

<div class="text">Logged Out Successfully!!</div>
<div class="link">
<a href="LoginPage.html">Login Page</a>
</div>

<% 
	HttpSession httpSession = request.getSession();
	httpSession.invalidate();
%>
	
</body>
</html>