package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userLoginID = req.getParameter("user");
		String password = req.getParameter("password");
	
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		
		boolean log = false;
		
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		
		try {
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			Statement st = con.createStatement();
						
			ResultSet rs = st.executeQuery("select * from userlogin");
			
			while(true) {
				rs.next();
				if(rs.isAfterLast()) {
					break;
				}else {
					if(userLoginID.equals(rs.getString(1))) {
						if(password.equals(rs.getString(2))) {
							log = true;
							session.setAttribute("password", password);
							RequestDispatcher rd = req.getRequestDispatcher("HomePage.jsp");
							rd.forward(req, res);
						}
					}
				}
			}
			if(log==false) {
				res.setContentType("text/html");
				RequestDispatcher rd = req.getRequestDispatcher("NotLogin.html");
				rd.forward(req, res);
			}
			
		}catch(Exception e) {
			
		}
		
//		out.println("Logged In!!");
//		out.println(userLoginID);
//		out.println(password);
	}
}
