package Project;

import java.sql.*;

public class Inserter {
	
	public static void main(String[] args) {
		String userLoginID = "bciue";
		String password = "bciuew";
		String partyId = "INDI0001";
		String ins2 = "insert into userlogin values(\""+userLoginID+"\",\""+password+"\",\""+partyId+"\")";
		
		insert(ins2);
	}
	
	public static String insert(String str) {
		String url = "jdbc:mysql://localhost:3306/advance_assignment";
		String uname = "root";
		String pass = "123456";
		String ret = "inserted!!";
		int i =0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			Statement st = con.createStatement();
			
			i = st.executeUpdate(str);
			
			ret = "Done!!";
		}catch(SQLException | ClassNotFoundException e) {e.printStackTrace();}
		return ret;
	}
}