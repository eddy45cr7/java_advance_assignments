package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String zip = req.getParameter("zip");
		String phone  = req.getParameter("phone");
		String userLoginID = req.getParameter("user");
		String password = req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		out.println("User Registered!!");
		
		String ins = "insert into party values('"+partyId+"','"+fname+"','"+lname+"','"+address+"','"+city+"','"+state+"','"+country+"','"+zip+"','"+phone+"')";
		
		int count = st.executeUpdate(ins);
		
		System.out.println("done");
		
		}catch(ClassNotFoundException | SQLException e) {}
	}

}
