package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Edit extends HttpServlet{
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
		
		try {
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from party where partyId=\""+partyId+"\"");
			rs.next();
			String[] details = new String[8];
			
			for(int i=0;i<8;i++) {
				details[i] = rs.getString(i+2);
			}
			
			session.setAttribute("details", details);
			session.setAttribute("id", partyId);
			res.sendRedirect("http://localhost:8085/customerRegistration/Edit.jsp");
			
		}catch(Exception e) {e.printStackTrace();}
	}
}