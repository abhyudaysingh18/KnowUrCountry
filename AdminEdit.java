package com.KnowUrCountry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminEdit
 */
@WebServlet("/AdminEdit")
public class AdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String state=request.getParameter("state");
		String name=request.getParameter("state");
		String capital=request.getParameter("capital");
		String cm=request.getParameter("cm");
		String rulingParty=request.getParameter("rulingParty");
		int population=Integer.parseInt(request.getParameter("population"));
		int landarea=Integer.parseInt(request.getParameter("landarea"));
		int noOfDistrict=Integer.parseInt(request.getParameter("noOfDistrict"));
		
		String url="jdbc:mysql://localhost:3306/practice?verifyServerCertificate=false&useSSL=true";
		String uname="root";
		String pword="password-18";
		
		PrintWriter out=response.getWriter();	
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,uname,pword);
		
		// the mysql insert statement
		String query="INSERT INTO "+state+" (name,capital,cm,ruling_party,population,`landarea(m^2)`,no_of_districts)" +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		
		 // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString (1, name);
	      preparedStmt.setString (2, capital);
	      preparedStmt.setString (3, cm);
	      preparedStmt.setString (4, rulingParty);
	      preparedStmt.setInt (5, population);
	      preparedStmt.setInt (6, landarea);
	      preparedStmt.setInt (7, noOfDistrict);
	      
	   // execute the preparedstatement
	      preparedStmt.execute();
	      
	      out.print("Details edited Successfully");
		
		con.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		
		}
		
	}

}
