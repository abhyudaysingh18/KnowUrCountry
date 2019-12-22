package com.KnowUrCountry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailsOfState
 */
@WebServlet("/DetailsOfState")
public class DetailsOfState extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stateName = (String) request.getParameter("state");
		PrintWriter out = response.getWriter();

		String url = "jdbc:mysql://localhost:3306/practice?verifyServerCertificate=false&useSSL=true";
		String uname = "root";
		String pword = "password-18";
		
		
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pword);

			// the mysql insert statement
			String query = "SELECT * from " + stateName;

			// execute the preparedstatement
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				String name = rs.getNString(1);
				String capital = rs.getString(2);
				String cm = rs.getString(3);
				String ruling_party = rs.getString(4);
				String population = rs.getString(5);
				String landArea = rs.getString(6);
				String noOfDistricts = rs.getString(7);
				
				out.println("<table border = \"1\" width = \"100%\" >");
				out.println(" <tr>");
				out.println(" <th>Name</th>");
				out.println(" <th>Capital</th>");
				out.println(" <th>Chief Minister</th>");
				out.println(" <th>Ruling Party</th>");
				out.println(" <th>Population</th>");
				out.println(" <th>Land Area</th>");
				out.println(" <th>No. of District</th>");
				out.println(" </tr>");
				
				out.println(" <tr>");
				out.println(" <td>"+name+"</td>");
				out.println(" <td>"+capital+"</td>");
				out.println(" <td>"+cm+"</td>");
				out.println(" <td>"+ruling_party+"</td>");
				out.println(" <td>"+population+"</td>");
				out.println(" <td>"+landArea+"</td>");
				out.println(" <td>"+noOfDistricts+"</td>");
				out.println(" </tr>");

			}

			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println(e.getMessage());

		}

	}

}
