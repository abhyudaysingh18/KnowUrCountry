package com.KnowUrCountry;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class RegistrationDatabase {
	

	public boolean connect(String fname,String lname,String email,String contact,String gender,String password)throws SQLException, ClassNotFoundException
	{
		
		String url="jdbc:mysql://localhost:3306/practice?verifyServerCertificate=false&useSSL=true";
		String uname="root";
		String pword="password-18";
	
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,uname,pword);
		
		// the mysql insert statement
		String query="INSERT INTO user (fname, lname, email, contact, gender, password)" +
        "VALUES (?, ?, ?, ?, ?, ?)";
		
		 // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString (1, fname);
	      preparedStmt.setString (2, lname);
	      preparedStmt.setString (3, email);
	      preparedStmt.setString (4, contact);
	      preparedStmt.setString (5, gender);
	      preparedStmt.setString (6, password);
	      
	   // execute the preparedstatement
	      preparedStmt.execute();
	      
	      System.out.println("User Registered Successfully");
		
		con.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		
		}
		return true;

	}
//		Connection con=null;
//		try {
//		con=DriverManager.getConnection(url,uname,pword);
//		
//		// the mysql insert statement
//		String query="INSERT INTO user (name,capital,cm,ruling_party,population,`landarea(m^2)`,no_of_districts)" +
//        "VALUES (?, ?, ?, ?, ?, ?, ?)";
//		
//		
//		 // create the mysql insert preparedstatement
//	      PreparedStatement preparedStmt = con.prepareStatement(query);
//	      preparedStmt.setString (1, "fname");
//	      preparedStmt.setString (2, "capital");
//	      preparedStmt.setString (3, "cm");
//	      preparedStmt.setString (4, "rulingParty");
//	      preparedStmt.setInt (5, 21);
//	      preparedStmt.setInt (6, 47);
//	      preparedStmt.setInt (7, 22);
//	   // execute the preparedstatement
//	      preparedStmt.execute();
//	      
//	      System.out.println("Details edited Successfully");
//		
//		con.close();
//		}
//		catch(SQLException e) {
//			System.err.println(e.getMessage());
//		
//		}
//		finally {
//		
//		}
		
	}


