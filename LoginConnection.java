package com.KnowUrCountry;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginConnection
 */
@WebServlet("/Login")
public class LoginConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("email");
		String password = request.getParameter("password");

		LoginDao loginDao = new LoginDao();
		if (loginDao.connect(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("WelcomeUser.html");
		} else {
			response.sendRedirect("Login.html");
		}
	}

}
