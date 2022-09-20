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

import org.joda.time.DateTime;

import com.icbtassignment.gct.entities.BranchMaster;
import com.icbtassignment.gct.entities.BranchMasterGridDto;
import com.icbtassignment.gct.entities.CityMaster;
import com.icbtassignment.gct.services.BranchMasterService;
import com.icbtassignment.gct.services.CityMasterServices;
import com.icbtassignment.gct.utils.EntityValidator;

@WebServlet("/BranchMasterServlet")
public class BranchMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;

	public BranchMasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String command = request.getParameter("command");
			
		if(command == null )
		{
			mainList(request,response);
		}
		else if(command.equals("SHOWLIST") )
		{
			mainList(request,response);
		}
		
		else if(command.equals("SHOWUPDATE") )
		{
			edit(request,response);
		}
		else if(command.equals("ADDNEW") )
		{
			addNew(request,response);
		}
		else
		{
			deleteList(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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

	protected void mainList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BranchMasterGridDto> oMaster = BranchMasterService.getList(dataSource);
		request.setAttribute("BranchList", oMaster);
		request.getRequestDispatcher("/BranchMasterList.jsp").forward(request, response);

	}

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int CityID = Integer.parseInt(request.getParameter("CityID"));
		int BranchID = 0;
		String BranchLocation = request.getParameter("BranchLocation");
		DateTime CreateDatetime = null;
		DateTime ModifiedDateTime = null;
		BranchMaster oMaster = new BranchMaster(CityID,BranchID, BranchLocation,CreateDatetime,ModifiedDateTime);

		EntityValidator<BranchMaster> validator = new EntityValidator<BranchMaster>();
		String errors = validator.validate(oMaster);

		if (!errors.isEmpty()) {
			request.setAttribute("BranchList", oMaster);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/BranchMasterAdd.jsp").forward(request, response);
		} else {
			BranchMasterService.AddNew(dataSource, oMaster);
			mainList(request, response);
		}

	}
	protected void addNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<CityMaster> cityDrp =  CityMasterServices.getCity(dataSource); 
		request.setAttribute("cityDrp", cityDrp);
		request.getRequestDispatcher("/BranchMasterAdd.jsp").forward(request, response);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CityMaster> cityDrp =  CityMasterServices.getCity(dataSource); 
		request.setAttribute("cityDrp", cityDrp);
		
		int id = Integer.parseInt(request.getParameter("BranchID"));
		BranchMaster oMaster = BranchMasterService.get(dataSource, id);
		
		request.setAttribute("BranchList", oMaster);
		request.getRequestDispatcher("/BranchMasterUpdate.jsp").forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int BranchID = Integer.parseInt(request.getParameter("BranchID"));
		int CityID = Integer.parseInt(request.getParameter("CityID"));
		String BranchLocation = request.getParameter("BranchLocation");
		DateTime CreateDatetime = null;
		DateTime ModifiedDateTime = null;
		BranchMaster oMaster = new BranchMaster(CityID,BranchID, BranchLocation, CreateDatetime, ModifiedDateTime);

		EntityValidator<BranchMaster> validator = new EntityValidator<BranchMaster>();
		String errors = validator.validate(oMaster);

		if (!errors.isEmpty()) {
			request.setAttribute("BranchList", oMaster);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/BranchMasterUpdate.jsp").forward(request, response);
		} else {
			BranchMasterService.Update(dataSource, oMaster);
			mainList(request, response);
		}
	}
	

	protected void deleteList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("BranchID"));
		BranchMasterService.Delete(dataSource, id);
		mainList(request, response);
	}
}
