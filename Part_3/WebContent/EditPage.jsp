<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="delete.css">
<meta charset="ISO-8859-1">
<title>Delete Records</title>
</head>
<body>

<%! 
	String url = "jdbc:mysql://localhost:3306/advance_assignment";
	String uname = "root";
	String pass = "123456"; 
%>

<div class="rectangle" id="tbl"></div>
<div class="rectangle" id="head"></div>
<div class="text" id="hed">Edit records</div>

<div class="delbut">
	<form action="delsel.jsp" method="post">

<%
	try{
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		
		%><table><%
		ResultSet r = st.executeQuery("describe party");
		%><tr><% 
		while(true){
			if(r.isBeforeFirst()){
				%><th>Check Box</th><%
				r.next();
			}else if(r.isAfterLast()){
				r.close();
				break;
			}else{
				%><th><%= r.getString(1) %></th><% 
				r.next();
			}  
		} %></tr><%
		
		ResultSet rs = st.executeQuery("select * from party");
		while(true){
			%><tr><%
			rs.next();
			if(rs.isAfterLast()){
				break;
			}else{
				%><td><input type="checkbox" name="<%= rs.getString(1) %>"></td><%
				for(int i=1;i<10;i++){
					%><td><%= rs.getString(i) %></td><%
				}
			%></tr><br><%
			}
		}
		%></table><% 
	}catch(Exception e){e.printStackTrace();}
%>
		<p id="pass">Password* : </p>
		<input type="password" id="pass" placeholder="enter your password" required>
		<button type="submit" id="final">Delete</button>
	</form>
</div>

<div class="back">
	<form action="HomePage.jsp" method="post">
		<button type="submit" id="back">Back</button>
	</form>
</div>

</body>
</html>