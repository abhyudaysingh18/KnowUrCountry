package com.KnowUrCountry;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationConnection
 */
@WebServlet("/RegistrationConnection")
public class RegistrationConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		
		RegistrationDatabase rd= new RegistrationDatabase();
		try {
			boolean rturn= rd.connect(fname, lname, email, contact, gender, password);
			if(rturn==true)
			{
			response.sendRedirect("Login.html");
			}
			else
			{
			response.sendRedirect("Registration.html");	
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
