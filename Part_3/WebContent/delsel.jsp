<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.io.PrintWriter,Project.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="delsel.css">
<title>Confirmation</title>
</head>
<body>

<div class="text">Deleted Records!!</div>
<div class="link"><a href="HomePage.jsp">Home Page</a></div>

	<%!
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		String id, state1, state2, sta;
		int h;
	%>

	<%
		try{
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			Statement st2 = con.createStatement();
			Statement st3 = con.createStatement();
			Statement st4 = con.createStatement();
			
			ResultSet r = st2.executeQuery("select * from party");
			while(r.next()){
				r.next();
				
				if(r.isAfterLast()){
					break;
				}else{
					id = r.getString(1);
					sta = request.getParameter(id);
					
					if(sta=="on"){
						state1 = "delete from userlogin where partyid=\""+id+"\"";
						state2 = "delete from party where partyid=\""+id+"\"";
						st3.executeUpdate(state1);
						st4.executeUpdate(state2);
						out.println("done");
					}else{
						continue;
					}
				}
			}
		}catch(Exception e){e.printStackTrace();}
	%>

</body>
</html>