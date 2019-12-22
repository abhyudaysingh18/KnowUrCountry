package com.KnowUrCountry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Guest
 */
@WebServlet("/Guest")
public class Guest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String state=request.getParameter("state");
		
		String query = "select state_capital from states_of_india where state_name=?";
		String url = "jdbc:mysql://localhost:3306/practice?verifyServerCertificate=false&useSSL=true";
		String uname = "root";
		String pword = "password-18";
	
			Connection con = null;
			try {
			    Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, uname, pword);
				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, state);
				ResultSet rs = st.executeQuery();
				if (rs.next())
				{
				String capital=rs.getNString("state_capital");
				PrintWriter writer=response.getWriter();
				writer.println("<table border = \"1\" width = \"100%\" >");
				writer.println(" <tr>");
				writer.println(" <th>Name</th>");
				writer.println(" <th>Capital</th>");
				writer.println(" </tr>");
				
				writer.println(" <tr>");
				writer.println(" <td>"+state+"</td>");
				writer.println(" <td>"+capital+"</td>");
				writer.println(" </tr>");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
