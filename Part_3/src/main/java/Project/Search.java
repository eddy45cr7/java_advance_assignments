package Project;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("userName");
		String password = (String) session.getAttribute("password");
		session.getMaxInactiveInterval();
		
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		
		String search = req.getParameter("search");
		
		String[] sqlcolumns = {"FirstName","LastName","Address","city","zip","state","country","phone"};
		
		Set<String> hset = new HashSet<>();
		
		try {
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			Statement st = con.createStatement();
			
			for(int i=0;i<8;i++) {
				String query = "SELECT partyId FROM party WHERE "+sqlcolumns[i]+" LIKE \"%"+search+"%\"";
				ResultSet rs = st.executeQuery(query);
				
				if(rs.next()==true) {
					while(true) {
						if(rs.isAfterLast()) {
							rs.close();
							break;
						}else {
							hset.add(rs.getString(1));
							rs.next();
						}
					}
					rs.close();
				}
			}
			
			Object[] ids = hset.toArray();
			
			session.setAttribute("set", ids);
			res.sendRedirect("http://localhost:8085/customerRegistration/SearchPage.jsp");
			
		}catch(Exception e) {e.printStackTrace();}
	}
}