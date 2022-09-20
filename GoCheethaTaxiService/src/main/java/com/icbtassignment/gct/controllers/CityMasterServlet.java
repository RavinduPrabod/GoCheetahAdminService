package com.icbtassignment.gct.controllers;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.icbtassignment.gct.entities.CityMaster;
import com.icbtassignment.gct.services.CityMasterServices;
import com.icbtassignment.gct.utils.EntityValidator;

@WebServlet("/CityMasterServlet")
public class CityMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;

	public CityMasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		if (command == null) {
			mainList(request, response);
		} else if (command.equals("SHOW-UPDATE")) {
			edit(request, response);
			command = request.getParameter("UPDATEDATA");
		} else if (command.equals("DELETE-LIST")) {
			deleteList(request, response);
		} else {
			mainList(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String command = request.getParameter("command");

		if (command.equals("ADDDATA")) {
			add(request, response);
		}

		if (command.equals("UPDATEDATA")) {
			update(request, response);

		}
		command = null;
	}

	protected void mainList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CityMaster> city = CityMasterServices.getCity(dataSource);
		request.setAttribute("CityList", city);
		request.getRequestDispatcher("/CityList.jsp").forward(request, response);

	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int CityID = 0;
		String CityName = request.getParameter("CityName");
		CityMaster city = new CityMaster(CityID, CityName);

		EntityValidator<CityMaster> validator = new EntityValidator<CityMaster>();
		String errors = validator.validate(city);

		if (!errors.isEmpty()) {
			request.setAttribute("city", city);
			request.setAttribute("error", errors);
			mainList(request, response);
		} else {
			CityMasterServices.addcity(dataSource, city);
			mainList(request, response);
		}

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cityId = Integer.parseInt(request.getParameter("CityID"));
		CityMaster city = CityMasterServices.get(dataSource, cityId);

		request.setAttribute("CityList", city);
		request.getRequestDispatcher("/CityUpdate.jsp").forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CityID = Integer.parseInt(request.getParameter("CityID"));
		String CityName = request.getParameter("CityName");

		CityMaster city = new CityMaster(CityID, CityName);
		EntityValidator<CityMaster> validator = new EntityValidator<CityMaster>();
		String errors = validator.validate(city);

		if (!errors.isEmpty()) {
			request.setAttribute("CityList", city);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/CityUpdate.jsp").forward(request, response);
		} else {
			CityMasterServices.updatecity(dataSource, city);
			mainList(request, response);
		}
	}

	protected void deleteList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CityID = Integer.parseInt(request.getParameter("CityID"));
		CityMasterServices.deleteCity(dataSource, CityID);
		mainList(request, response);
	}
}
