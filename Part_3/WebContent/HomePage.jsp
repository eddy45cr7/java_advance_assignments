<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style2.css">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<title>Welcome</title>
</head>
<body>
	
	<div class="rectangle" id="tbl"></div>
	<div class="rectangle" id="heading"></div>
	<div class="text" id="hed">Customers Information</div>
	
	<div class="tab">
		<%!
			String url = "jdbc:mysql://localhost:3306/advance_assignment";
			String uname = "root";
			String pass = "123456";
			String password;
		%><%
			//String password = request.getAttribute("password").toString();
			try{
				%><table><%
				Connection con = DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				
				ResultSet r = st.executeQuery("describe party");
				%>
				<tr>
				<% 
				while(true){
					r.next();
					if(r.isAfterLast()){
						r.close();
						break;
					}else{
						%>
						<th><%= r.getString(1) %></th>
					<% }  
				} %></tr><%
				
				ResultSet rs = st.executeQuery("select * from party");
				while(true){
					rs.next();
					if(rs.isAfterLast()){
						rs.close();
						break;
					}else{
						%><tr><%
						for(int i=1;i<10;i++){
							%><td><%= rs.getString(i) %></td><%
						}
						%></tr><%
					}
				}
				%></table><% 
			}catch(Exception e){e.printStackTrace();}
		%>
	</div>
	
	<div class="info">
		<form id="show" action="LogoutPage.jsp" method="post">
			<button type="submit" id="logout">Log Out</button>
		</form><form id="edit" action="EditPage.jsp" method="post">
			<button type="submit" id="edit">Edit Records</button>
		</form><form id="delete" action="Delete.jsp" method="post">
			<button type="submit" id="delete">Delete Record</button>
		</form>		
	</div>
</body>
</html>