package Project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userLoginID = req.getParameter("user");
		String password = req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		out.println("Logged In!!");
		out.println(userLoginID);
		out.println(password);
	}
}
