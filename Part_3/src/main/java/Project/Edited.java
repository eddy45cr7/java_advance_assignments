package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Edited extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String password = (String) session.getAttribute("password");
		String partyId = (String) session.getAttribute("id");
		session.getMaxInactiveInterval();
		
		PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		
		String[] pars = {"fname","lname","address","city","zip","state","country","phone"};
		String[] vals = new String[8];
		
		for(int i=0;i<8;i++) {
			vals[i] = request.getParameter(pars[i]);
		}
		
		String[] sqlcolumns = {"FirstName","LastName","Address","city","zip","state","country","phone"};
		
		try {
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			
			for(int i=0;i<8;i++) {
				if(vals[i].length()>0) {
					String query = "UPDATE party SET "+sqlcolumns[i]+"=\""+vals[i]+"\" WHERE partyId=\""+partyId+"\"";
					st.executeUpdate(query);
				}
			}
			
			response.sendRedirect("http://localhost:8085/customerRegistration/HomePage.jsp");
			
		}catch(Exception e) {e.printStackTrace();}
	}
}