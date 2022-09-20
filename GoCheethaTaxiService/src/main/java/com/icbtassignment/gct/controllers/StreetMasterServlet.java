package com.icbtassignment.gct.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.icbtassignment.gct.entities.CityMaster;
import com.icbtassignment.gct.entities.StreetMaster;
import com.icbtassignment.gct.entities.StreetMasterDto;
import com.icbtassignment.gct.services.CityMasterServices;
import com.icbtassignment.gct.services.StreetMasterService;
import com.icbtassignment.gct.utils.EntityValidator;


@WebServlet("/StreetMasterServlet")
public class StreetMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;
	
    public StreetMasterServlet() {
        super();      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");

		if (command == null) {
			mainList(request, response);
		} else if (command.equals("SHOW-UPDATE")) {
			edit(request, response);
		} else if (command.equals("DELETE-LIST")) {
			deleteList(request, response);
		} 
		else if(command.equals("ADDNEW") )
		{
			addNew(request,response);
			command = null;
		}
		else {
			mainList(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String command = request.getParameter("command");

		if (command.equals("ADDDATA")) {
			add(request, response);
		}

		if (command.equals("UPDATEDATA")) {
			update(request, response);

		}
		command = null;
	}
	
	protected void addNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<CityMaster> cityDrp =  CityMasterServices.getCity(dataSource); 
		request.setAttribute("cityDrp", cityDrp);
		request.getRequestDispatcher("/StreetMasterAdd.jsp").forward(request, response);
	}

	protected void mainList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<StreetMasterDto> StreetList = StreetMasterService.getList(dataSource);
		request.setAttribute("StreetList", StreetList);
		request.getRequestDispatcher("/StreetMasterList.jsp").forward(request, response);

	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int StreetID = 0;
		int CityID = Integer.parseInt(request.getParameter("CityID"));
		String StreetName = request.getParameter("StreetName");
		StreetMaster Street = new StreetMaster(StreetID, StreetName, CityID);

		EntityValidator<StreetMaster> validator = new EntityValidator<StreetMaster>();
		String errors = validator.validate(Street);

		if (!errors.isEmpty()) {
			request.setAttribute("Street", Street);
			request.setAttribute("error", errors);
			mainList(request, response);
		} else {
			StreetMasterService.AddNew(dataSource, Street);
			mainList(request, response);
		}

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CityMaster> cityDrp =  CityMasterServices.getCity(dataSource); 
		request.setAttribute("cityDrp", cityDrp);
		
		int StreetID = Integer.parseInt(request.getParameter("StreetID"));
		StreetMaster olist =StreetMasterService.getData(dataSource, StreetID);

		request.setAttribute("Street", olist);
		request.getRequestDispatcher("/StreetMasterUpdate.jsp").forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		
		int CityID = Integer.parseInt(request.getParameter("CityID"));
		int StreetID = Integer.parseInt(request.getParameter("StreetID"));
		String StreetName = request.getParameter("StreetName");

		StreetMaster city = new StreetMaster(StreetID,StreetName,CityID);
		EntityValidator<StreetMaster> validator = new EntityValidator<StreetMaster>();
		String errors = validator.validate(city);

		if (!errors.isEmpty()) {
			request.setAttribute("CityList", city);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/StreetMasterUpdate.jsp").forward(request, response);
		} else {
			StreetMasterService.update(dataSource, city);
			mainList(request, response);
		}
	}

	protected void deleteList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CityID = Integer.parseInt(request.getParameter("CityID"));
		StreetMasterService.delete(dataSource, CityID);
		mainList(request, response);
	}

}
