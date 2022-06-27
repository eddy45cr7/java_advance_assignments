package Project;

import java.sql.*;

public class PartyIdCreator extends UserReg {
	private static final long serialVersionUID = 1L;
	
	public static String create(String country) {
		String id="";
		String countrycount = "select count(Firstname) from party where country='"+country.toUpperCase()+"'";
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		String emp = "";
		
		int count=0;
		int c=0;
		
		for(int i=0;i<4;i++) {
			if(country.equals("usa".toUpperCase())) {
				country="usoa";
			}
			emp = Character.toString(country.charAt(i)).toUpperCase();
			id += emp;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(countrycount);
			rs.next();
			
			c = Integer.parseInt(rs.getString(1));
			
			count = c+1;
			emp = Integer.toString(count);
			int size = emp.length();
			
			if(size==1) {
				id += "000";
			}else if(size==2) {
				id += "00";
			}else if(size==3) {
				id += "0";
			}
			
			id += emp;
			
			return id;
			
		}catch(SQLException | ClassNotFoundException e) {}
		
		return id;
	}
	
	public static void main(String[] args) {
		String c = "india";
		System.out.println(create(c));
	}
}