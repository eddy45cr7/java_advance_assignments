package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("userName");
		String password = (String) session.getAttribute("password");
		session.getMaxInactiveInterval();
		
		PrintWriter out = res.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		
		String partyId = req.getParameter("id");
		String deluser = "delete from userlogin where partyid=\""+partyId+"\"";
		String delparty = "delete from party where partyid=\""+partyId+"\"";
		
		try {
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
						
			int delus = st.executeUpdate(deluser);
			int delpa = st1.executeUpdate(delparty);
			
			
			res.sendRedirect("http://localhost:8085/customerRegistration/HomePage.jsp");
			
		}catch(Exception e) {e.printStackTrace();}
	}
}