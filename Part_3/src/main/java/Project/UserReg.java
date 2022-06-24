package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/register")

class SqlThings {
	public String insert(String str) {
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		String ret = "inserted!!";
		int i =0;
		
		try{
			/* Class.forName("com.mysql.jdbc.Driver"); */
			
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			Statement st = con.createStatement();
						
			st.executeUpdate(str);
			
			ret = "Done!!";
			
			st.close();
			con.close();
			return ret;
		}catch(SQLException e) {
			e.printStackTrace();
			}
		return ret;

	}
}

public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String zip = req.getParameter("zip");
		String phone  = req.getParameter("phone");
		String userLoginID = req.getParameter("user");
		String password = PasswordEncrypt.encryptor(PasswordEncrypt.encryptor(req.getParameter("password")));
		String partyId = PartyIdCreator.create(country);
		
		String ins = "insert into party values(\""+partyId+"\",\""+fname+"\",\""+lname+"\",\""+address+"\",\""+city+"\",\""+zip+"\",\""+state+"\",\""+country+"\",\""+phone+"\")";
		String ins2 = "insert into userlogin values(\""+userLoginID+"\",\""+password+"\",\""+partyId+"\")";
		
		PrintWriter out = res.getWriter();
		SqlThings t = new SqlThings ();
		out.println(t.insert(ins));
		
		out.println(t.insert(ins2));
			
		res.setContentType("text/html");
		RequestDispatcher rd = req.getRequestDispatcher("RegisteredScreen.jsp");
		rd.forward(req, res);
	}
	
	
		String userLoginID = "aaabb";
		String password = "bciuew";
		String partyId = "INDI0001";
		String ins2 = "insert into userlogin values(\""+userLoginID+"\",\""+password+"\",\""+partyId+"\")";
		SqlThings t = new SqlThings ();
		//System.out.println(t.insert(ins2));
	}


