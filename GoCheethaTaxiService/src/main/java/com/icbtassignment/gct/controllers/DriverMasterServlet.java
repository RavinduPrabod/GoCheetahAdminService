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

import org.joda.time.DateTime;

import com.icbtassignment.gct.entities.BranchMasterGridDto;
import com.icbtassignment.gct.entities.DriverMaster;
import com.icbtassignment.gct.entities.DriverMasterGridDto;
import com.icbtassignment.gct.entities.StatusDto;
import com.icbtassignment.gct.entities.VehicleMasterGridDto;
import com.icbtassignment.gct.services.BranchMasterService;
import com.icbtassignment.gct.services.DriverMasterService;
import com.icbtassignment.gct.services.VehicleMasterService;
import com.icbtassignment.gct.utils.EntityValidator;


@WebServlet("/DriverMasterServlet")
public class DriverMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name ="jdbc/gocheetha_application")
    private DataSource dataSource;
    public DriverMasterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
		if(command == null )
		{
			mainList(request,response);
		}
		else if(command.equals("SHOW-LIST") )
		{
			mainList(request,response);
		}
		
		else if(command.equals("SHOW-UPDATE") )
		{
			edit(request,response);
			command = request.getParameter("UPDATEDATA");
		}
		else if(command.equals("SHOW-ADDDATA") )
		{
			add(request,response);
		}
		else if(command.equals("ADDNEW") )
		{
			addNew(request,response);
			command = request.getParameter("ADDDATA");
		}
		else
		{
			deleteList(request,response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command =request.getParameter("command");
		
		if(command.equals("ADDDATA") )
		{
			add(request,response);
		}
		
		if(command.equals("UPDATEDATA") )
		{
			update(request,response);
		}
		
	}
	
	protected void addNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BranchMasterGridDto> BrnDrp =  BranchMasterService.getList(dataSource); 
		request.setAttribute("BrnDrp", BrnDrp);
		
		List<VehicleMasterGridDto> vnDrp =  VehicleMasterService.getList(dataSource); 
		request.setAttribute("vnDrp", vnDrp);
		
		request.getRequestDispatcher("/DriverMasterAdd.jsp").forward(request, response);
	}
	
	protected void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DriverMasterGridDto> oDriverMasterGridDto =  DriverMasterService.getDriverList(dataSource);
		request.setAttribute("DriversList", oDriverMasterGridDto);
		request.getRequestDispatcher("/DriverMasterList.jsp").forward(request, response);
		
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//List<BranchMaster> oBranchMaster =  BranchMasterService.getBranchList(dataSource);
			int DriverID = 0;
			String DriverName = request.getParameter("DriverName");
			String ContactNo = request.getParameter("ContactNo");
			String NIC = request.getParameter("NIC");
			String LicenseNo = request.getParameter("LicenseNo");
			int BranchID = Integer.parseInt(request.getParameter("BranchID"));	
			String VehicleNo = request.getParameter("VehicleNo");
			String UserName = request.getParameter("UserName");
			String Password = request.getParameter("Password");
			int Status = Integer.parseInt(request.getParameter("Status"));
			DateTime CreateDatetime = null;
			DateTime ModifiedDateTime = null;
			DriverMaster oDriverMaster = new DriverMaster(DriverID,DriverName,ContactNo,NIC,LicenseNo,BranchID,VehicleNo,UserName,Password,Status,CreateDatetime,ModifiedDateTime);
			
			EntityValidator<DriverMaster> validator = new EntityValidator<DriverMaster>();
			String errors = validator.validate(oDriverMaster);
			
			if(!errors.isEmpty()) {
				request.setAttribute("DriversList", oDriverMaster);
				request.setAttribute("error", errors);
				request.getRequestDispatcher("/DriverMasterAdd.jsp").forward(request, response);
			}else {
				DriverMasterService.AddNewDriver(dataSource, oDriverMaster);
				mainList(request,response);
			}
			
		}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		List<VehicleMasterGridDto> vhlist =  VehicleMasterService.getList(dataSource); 
		request.setAttribute("vhlist", vhlist);
		
		List<BranchMasterGridDto> BrnDrp =  BranchMasterService.getList(dataSource); 
		request.setAttribute("BrnDrp", BrnDrp);	
		
		ArrayList<StatusDto> Statusl = new ArrayList<StatusDto>();
		Statusl.add(new StatusDto(1,"Active"));
		Statusl.add(new StatusDto(2,"Incative"));
		request.setAttribute("slist", Statusl);
		
		int DriverID= Integer.parseInt(request.getParameter("DriverID"));	
		DriverMasterGridDto oDriverMaster = DriverMasterService.get(dataSource,DriverID);
		request.setAttribute("oDriverMaster", oDriverMaster);
		
		request.getRequestDispatcher("/DriverMasterUpdate.jsp").forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int DriverID = Integer.parseInt(request.getParameter("DriverID"));
		String DriverName = request.getParameter("DriverName");
		String ContactNo = request.getParameter("ContactNo");
		String NIC = request.getParameter("NIC");
		String LicenseNo = request.getParameter("LicenseNo");
		String VehicleNo = request.getParameter("VehicleNo");
		String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
		int Status = Integer.parseInt(request.getParameter("Status"));
		int BranchID = Integer.parseInt(request.getParameter("BranchID"));
		DateTime CreateDatetime = null;
		DateTime ModifiedDateTime = null;
		DriverMaster oDriverMaster = new DriverMaster(DriverID,DriverName,ContactNo,NIC,LicenseNo,BranchID,VehicleNo,UserName,Password,Status,CreateDatetime,ModifiedDateTime);
		
		EntityValidator<DriverMaster> validator = new EntityValidator<DriverMaster>();
		String errors = validator.validate(oDriverMaster);
		
		if(!errors.isEmpty()) {
			request.setAttribute("DriversList", oDriverMaster);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/DriverMasterUpdate.jsp").forward(request, response);
		}else {
			DriverMasterService.UpdateDriver(dataSource, oDriverMaster);
			mainList(request,response);
		}
			
	}
	
	protected void deleteList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int DriverID= Integer.parseInt(request.getParameter("DriverID"));	
		DriverMasterService.DeleteDriver(dataSource,DriverID);
		mainList(request,response);
	}

}
