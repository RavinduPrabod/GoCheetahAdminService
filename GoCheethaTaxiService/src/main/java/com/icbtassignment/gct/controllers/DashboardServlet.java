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

import com.icbtassignment.gct.entities.DashboardDto;
import com.icbtassignment.gct.services.DashboardService;


@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DashboardServlet() {
        super();
    }
    @Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String type = (String) session.getAttribute("type");
		
		if (type.equals("Driver")) {
					
			int DriverID = (int) session.getAttribute("DriverID");

			String PendingCount =  DashboardService.PendingCountD(dataSource, DriverID).toString(); 
			String ActiveCount =  DashboardService.ActiveCountD(dataSource,DriverID).toString(); 
			String CompleteCount =  DashboardService.CompleteCountD(dataSource,DriverID).toString();
			String CancelCount =  DashboardService.CancelCountD(dataSource,DriverID).toString(); 
			String Revenue =  DashboardService.RevenueD(dataSource,DriverID).toString(); 
			
			DashboardDto oDash = new DashboardDto(PendingCount,ActiveCount,CompleteCount,CancelCount,Revenue);
			request.setAttribute("oDash", oDash);
			request.getRequestDispatcher("/DriverDashboard.jsp").forward(request, response);
		}
		if (type.equals("Administration")) {
			
			String PendingCount =  DashboardService.PendingCount(dataSource).toString(); 
			String ActiveCount =  DashboardService.ActiveCount(dataSource).toString(); 
			String CompleteCount =  DashboardService.CompleteCount(dataSource).toString(); 
			String Revenue =  DashboardService.Revenue(dataSource).toString(); 
			String CustomerCount =  DashboardService.CustomerCount(dataSource).toString(); 
			String DriverCount =  DashboardService.DriverCount(dataSource).toString(); 
			String VehicleCount =  DashboardService.VehicleCount(dataSource).toString(); 
			String BranchCount =  DashboardService.BranchCount(dataSource).toString(); 
			String CancelCount =  DashboardService.CancelCount(dataSource).toString(); 
			int users = Integer.parseInt(CustomerCount) + Integer.parseInt(DriverCount); 
			String UserCount =  String.valueOf(users).toString();
			
			DashboardDto oDash = new DashboardDto(PendingCount,ActiveCount,CompleteCount,Revenue,CustomerCount,DriverCount,VehicleCount,BranchCount,CancelCount,UserCount);
			request.setAttribute("oDash", oDash);
			request.getRequestDispatcher("/AdminDashboard.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
