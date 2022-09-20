package com.icbtassignment.gct.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.icbtassignment.gct.entities.DriverMaster;
import com.icbtassignment.gct.services.DriverMasterService;
import com.icbtassignment.gct.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("LoginForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginAuthentication(request, response);
	}
	
	private void LoginAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String user_Name = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();

		try {

			if (LoginService.checkAuthentication(dataSource, type, user_Name, password)) {

				if (type.equals("Driver")) {

					DriverMaster driver = DriverMasterService.getDriverCardentials(dataSource, user_Name);

					session.setAttribute("DriverID", driver.getDriverID());
					session.setAttribute("UserName", driver.getDriverName());
					session.setAttribute("VehicleNo", driver.getVehicleNo());
					session.setAttribute("type", type);
					
					request.setAttribute("lblUserName", driver.getDriverName());
					response.sendRedirect("DashboardServlet");
				}
				if (type.equals("Administration")) {
					
					session.setAttribute("ID", "admin");
					session.setAttribute("UserName", "Administrator");
					session.setAttribute("type", type);
					
					request.setAttribute("lblUserName", "Administrator");
					response.sendRedirect("DashboardServlet");
				}

			} else {
				request.setAttribute("exceptionerror", "User Credinatial incorrect");
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
			}
		} catch (Exception e) {

			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);

		}
	}

}
