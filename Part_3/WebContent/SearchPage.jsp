<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Details</title>
<%@page import="java.sql.*" %>
<link rel="stylesheet" href="search.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<div class="rectangle" id="tbl"></div>
	<div class="rectangle" id="heading"></div>
	<div class="text" id="hed">Search Results</div>

	<%!
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";	
	%>
		
		<%
			
			String userName = (String) session.getAttribute("userName");
			String password = (String) session.getAttribute("password");
			session.getMaxInactiveInterval();

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
				
				Object[] ids = (Object[]) session.getAttribute("set");
				String query = "SELECT * FROM party WHERE ";
				
				for(int q=0;q<ids.length;q++){
					if(q==0){
						query+="partyId = \""+ids[q].toString()+"\"";
					}else{
						query+="or partyId = \""+ids[q].toString()+"\"";
					}
				}
				
				ResultSet rs = st.executeQuery(query);
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
						%>
						<td><a href="http://localhost:8085/customerRegistration/edit?id=<%= rs.getString(1) %>"><button type="submit" id="edit">Edit</button></a></td>
						<td><a href="http://localhost:8085/customerRegistration/delete?id=<%= rs.getString(1) %>"><button type="submit" id="delete">Delete</button></a></td>
						</tr><%
					}
				}
				%></table><% 
			}catch(Exception e){e.printStackTrace();}
			%>
			
		<div class="home">
		<form id="home" action="HomePage.jsp" method="post">
			<button type="submit" id="home">Home</button>
		</form>
		</div>
	</body>
</html> 