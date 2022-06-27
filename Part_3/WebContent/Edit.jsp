<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.io.PrintWriter,java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="edit.css">
<title>Edit Page</title>
</head>
<body>
	<div class="rectangle" id="heading"></div>
	
	<div class="form"><form action="edited" method="Post">
	<%
		String userName = (String) session.getAttribute("userName");
		String password = (String) session.getAttribute("password");
		session.getMaxInactiveInterval();
		
		String partyId = (String) session.getAttribute("id");
		String[] details = (String[]) session.getAttribute("details");
		
	%>		
	<div class="text" id="hed">Edit Record for partyId=<%= partyId %></div>
	<input class="info" type="text" name="fname" id="name" placeholder="<%= details[0] %>">
	<input class="info" type="text" name="lname" id="lname" placeholder="<%= details[1] %>">
	<input class="info" type="text" name="address" id="add" placeholder="<%= details[2] %>">
	<input class="info" type="text" name="city" id="city" placeholder="<%= details[3] %>">
	<input class="info" type="text" name="zip" id="zip" placeholder="<%= details[4] %>">
	<input class="info" type="text" name="state" id="state" placeholder="<%= details[5] %>">
	<input class="info" type="text" name="country" id="country" placeholder="<%= details[6] %>">
	<input class="info" type="text" name="phone" id="phone" placeholder="<%= details[7] %>">
	
	<button type="submit" id="edit">Done</button>	
	</form></div>
	
	<a href="http://localhost:8085/customerRegistration/HomePage.jsp"><button type="submit" id="cancel">Cancel</button></a>

</body>
</html>