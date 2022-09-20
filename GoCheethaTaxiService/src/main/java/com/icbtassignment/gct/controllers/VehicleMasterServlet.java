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
import javax.swing.JComboBox;

import org.joda.time.DateTime;

import com.icbtassignment.gct.entities.BranchMaster;
import com.icbtassignment.gct.entities.BranchMasterGridDto;
import com.icbtassignment.gct.entities.StatusDto;
import com.icbtassignment.gct.entities.VehicleMaster;
import com.icbtassignment.gct.entities.VehicleMasterGridDto;
import com.icbtassignment.gct.entities.VehicleTypeDto;
import com.icbtassignment.gct.services.BranchMasterService;
import com.icbtassignment.gct.services.VehicleMasterService;
import com.icbtassignment.gct.utils.EntityValidator;


@WebServlet("/VehicleMasterServlet")
public class VehicleMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;

    public VehicleMasterServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String command = request.getParameter("command");

		if (command == null) {
			mainList(request, response);
		} else if (command.equals("SHOW-UPDATE")) {
			edit(request, response);
			command = request.getParameter("UPDATEDATA");
		} else if (command.equals("DELETE-LIST")) {
			deleteList(request, response);
		}
		else if(command.equals("ADDNEW") )
		{
			addNew(request,response);
			command = request.getParameter("ADDDATA");
		}else {
			mainList(request, response);
		}
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
	protected void addNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BranchMasterGridDto> BrnDrp =  BranchMasterService.getList(dataSource); 
		request.setAttribute("BrnDrp", BrnDrp);
		request.getRequestDispatcher("/VehicleMasterAdd.jsp").forward(request, response);
	}
	protected void mainList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<VehicleMasterGridDto> oMaster = VehicleMasterService.getList(dataSource);
		request.setAttribute("VehicleList", oMaster);
		request.getRequestDispatcher("/VehicleMasterList.jsp").forward(request, response);

	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String VehicleNo = request.getParameter("VehicleNo");
		String VehicleOwnerName = request.getParameter("VehicleOwnerName");
		int BranchID = Integer.parseInt(request.getParameter("BranchID"));
		Float AmountperKM = Float.parseFloat(request.getParameter("AmountperKM"));
		int VehicleType = Integer.parseInt(request.getParameter("VehicleType"));
		int Status = Integer.parseInt(request.getParameter("Status"));
		DateTime CreateDatetime = null;
		DateTime ModifiedDateTime = null;
		VehicleMaster oMaster = new VehicleMaster(VehicleNo, VehicleType, VehicleOwnerName, BranchID,AmountperKM, Status, CreateDatetime, ModifiedDateTime);

		EntityValidator<VehicleMaster> validator = new EntityValidator<VehicleMaster>();
		String errors = validator.validate(oMaster);

		if (!errors.isEmpty()) {
			request.setAttribute("VehicleList", oMaster);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/VehicleMasterAdd.jsp").forward(request, response);
		} else {
			VehicleMasterService.AddNew(dataSource, oMaster);
			mainList(request, response);
		}

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<VehicleTypeDto> vehicleList = new ArrayList<VehicleTypeDto>();
			vehicleList.add(new VehicleTypeDto(1,"Tuk-tuk"));
			vehicleList.add(new VehicleTypeDto(2,"Car"));
			vehicleList.add(new VehicleTypeDto(3,"Van"));
			vehicleList.add(new VehicleTypeDto(4,"Lorry"));	
			request.setAttribute("vhlist", vehicleList);
			
			List<BranchMasterGridDto> BrnDrp =  BranchMasterService.getList(dataSource); 
			request.setAttribute("BrnDrp", BrnDrp);
			
			
			ArrayList<StatusDto> Statusl = new ArrayList<StatusDto>();
			Statusl.add(new StatusDto(1,"Active"));
			Statusl.add(new StatusDto(2,"Incative"));
			request.setAttribute("slist", Statusl);
			
			String id = request.getParameter("VehicleNo");
			VehicleMaster oMaster = VehicleMasterService.get(dataSource, id);
			
			request.setAttribute("VehicleList", oMaster);
			request.getRequestDispatcher("/VehicleMasterUpdate.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}
		

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String VehicleNo = request.getParameter("VehicleNo");
		String VehicleOwnerName = request.getParameter("VehicleOwnerName");
		int BranchID = Integer.parseInt(request.getParameter("cmbBrID"));
		int VehicleType = Integer.parseInt(request.getParameter("cmbvhVal"));
		Float AmountperKM = Float.parseFloat(request.getParameter("AmountperKM"));
		int Status = Integer.parseInt(request.getParameter("cmbStatus"));
		DateTime CreateDatetime = null;
		DateTime ModifiedDateTime = null;
		VehicleMaster oMaster = new VehicleMaster(VehicleNo, VehicleType, VehicleOwnerName, BranchID,AmountperKM, Status, CreateDatetime, ModifiedDateTime);;

		EntityValidator<VehicleMaster> validator = new EntityValidator<VehicleMaster>();
		String errors = validator.validate(oMaster);

		if (!errors.isEmpty()) {
			request.setAttribute("VehicleList", oMaster);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/VehicleMasterUpdate.jsp").forward(request, response);
		} else {
			VehicleMasterService.Update(dataSource, oMaster);
			mainList(request, response);
		}
	}

	protected void deleteList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("VehicleNo");
		VehicleMasterService.Delete(dataSource, id);
		mainList(request, response);
	}
}
