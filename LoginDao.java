package com.KnowUrCountry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	String query = "select * from practice.user where email=? and password=?";
	String url = "jdbc:mysql://localhost:3306/practice?verifyServerCertificate=false&useSSL=true";
	String uname = "root";
	String pword = "password-18";

	public boolean connect(String email, String password) {

		
		Connection con = null;
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pword);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
