package com.icbtassignment.gct.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.icbtassignment.gct.entities.ServiceCharge;
import com.icbtassignment.gct.entities.VehicleTypeDto;
import com.icbtassignment.gct.services.ServiceChargeService;
import com.icbtassignment.gct.utils.EntityValidator;


@WebServlet("/ServiceChargeServlet")
public class ServiceChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;
	
    public ServiceChargeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");

		if (command == null) {
			mainList(request, response);
		} 
			 else if (command.equals("SHOW-UPDATE")) { edit(request, response); command =
			 request.getParameter("UPDATEDATA"); } 
			 
			 else if (command.equals("DELETE-LIST"))
			 { deleteList(request, response); } else { mainList(request, response); }
			 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		List<ServiceCharge> SerCharge = ServiceChargeService.GetList(dataSource);
		request.setAttribute("SerCharge", SerCharge);
		request.getRequestDispatcher("/ServiceCharges.jsp").forward(request, response);

	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int VehicleType =Integer.parseInt(request.getParameter("VehicleType"));
		String Amount = request.getParameter("Amount");
		ServiceCharge SerCharge = new ServiceCharge(VehicleType, Amount);

		EntityValidator<ServiceCharge> validator = new EntityValidator<ServiceCharge>();
		String errors = validator.validate(SerCharge);

		if (!errors.isEmpty()) {
			request.setAttribute("SerCharge", SerCharge);
			request.setAttribute("error", errors);
			mainList(request, response);
		} else {
			ServiceChargeService.add(dataSource, SerCharge);
			mainList(request, response);
		}

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<VehicleTypeDto> vehicleList = new ArrayList<VehicleTypeDto>();
		vehicleList.add(new VehicleTypeDto(1,"Tuk-tuk"));
		vehicleList.add(new VehicleTypeDto(2,"Car"));
		vehicleList.add(new VehicleTypeDto(3,"Van"));
		vehicleList.add(new VehicleTypeDto(4,"Lorry"));	
		request.setAttribute("vhlist", vehicleList);
		
		int VehicleType = Integer.parseInt(request.getParameter("VehicleType"));
		String Amount = request.getParameter("Amount");
		ServiceCharge SerCharge = new ServiceCharge(VehicleType, Amount);

		request.setAttribute("SerCharge", SerCharge);
		request.getRequestDispatcher("/ServiceCharges.jsp").forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int VehicleType = Integer.parseInt(request.getParameter("VehicleType"));
		String Amount = request.getParameter("Amount");

		ServiceCharge SerCharge = new ServiceCharge(VehicleType, Amount);
		EntityValidator<ServiceCharge> validator = new EntityValidator<ServiceCharge>();
		String errors = validator.validate(SerCharge);

		if (!errors.isEmpty()) {
			request.setAttribute("SerCharge", SerCharge);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/ServiceCharges.jsp").forward(request, response);
		} else {
			ServiceChargeService.update(dataSource, SerCharge);
			mainList(request, response);
		}
	}

	protected void deleteList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("VehicleType"));
		ServiceChargeService.delete(dataSource, type);
		mainList(request, response);
	}

}
