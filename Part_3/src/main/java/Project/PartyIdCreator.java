package Project;

import java.sql.*;

public class PartyIdCreator extends UserReg {
	private static final long serialVersionUID = 1L;
	
	public String create(String country) {
		String id="";
		String countrycount = "select count(name) from city where country='"+country+"'";
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		String emp = "";
		
		int count=0;
		
		for(int i=0;i<4;i++) {
			emp = Character.toString(country.charAt(i)).toUpperCase();
			id += emp;
		}
		
		try {
				
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(countrycount);
			rs.next();
			
			count = Integer.parseInt(rs.getString(1));
			
		}catch(SQLException | ClassNotFoundException e) {}
		
		emp = Integer.toString(count+1);
		
		for(int i=0;i<4;i++) {
			
		}
		
		return id;
	}
}