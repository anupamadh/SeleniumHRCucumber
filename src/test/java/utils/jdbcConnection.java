package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnection {
	String host="localhost";
	String port= "3306";
	String username = null;
	String password = null;
	public void getConnection() throws SQLException {
	Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "Chhavi123");
	Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("select * from employee");
	while(rs.next())
	{
		username = rs.getString("username");
		password = rs.getString("user_password");
	}
	
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	
}
