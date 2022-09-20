package com.icbtassignment.gct.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.icbtassignment.gct.entities.ActiveBookingListDto;
import com.icbtassignment.gct.entities.CancelBookingListDto;
import com.icbtassignment.gct.entities.CustomerMaster;
import com.icbtassignment.gct.entities.DRidePendingListDto;
import com.icbtassignment.gct.entities.PendingBookingListDto;
import com.icbtassignment.gct.services.BookingMasterService;

@WebServlet("/BookingMasterServlet")
public class BookingMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookingMasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command == null )
		{	
			mainList(request,response);
			
		}
		else if(command.equals("VIEWINFO") )
		{
			getCust(request,response);
			command = null;
		}	
		else if(command.equals("APPROVE") )
		{
			Authorize(request,response);
		}
		else if(command.equals("REJECT") )
		{
			Reject(request,response);
		}
		else if(command.equals("PENDING") )
		{	
			PendingList(request,response);		
		}
		else if(command.equals("ACTIVE") )
		{	
			ActiveList(request, response);		
		}
		else if(command.equals("COMPLETE") )
		{	
			COMPLETEList(request, response);		
		}
		else if(command.equals("CANCELED") )
		{	
			CANCELEDist(request, response);		
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command == null )
		{
			mainList(request,response);
			
		}
		else if(command.equals("VIEWINFO") )
		{
			getCust(request,response);
			command = null;
		}
		
		else if(command.equals("APPROVE") )
		{
			Authorize(request,response);
		}
		else if(command.equals("REJECT") )
		{
			Reject(request,response);
		}
	}
	
	protected void mainList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<DRidePendingListDto> oMaster = BookingMasterService.getDrvpendingList(dataSource);
			request.setAttribute("DrvpendingList", oMaster);
			request.getRequestDispatcher("/DRidePendingList.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	protected void PendingList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<PendingBookingListDto> oMaster = BookingMasterService.getAdpendingList(dataSource);
			request.setAttribute("DrvpendingList", oMaster);
			request.getRequestDispatcher("/PendingBookings.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	protected void ActiveList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<ActiveBookingListDto> oMaster = BookingMasterService.getAdActiveList(dataSource);
			request.setAttribute("DrvpendingList", oMaster);
			request.getRequestDispatcher("/ActiveBookingList.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	protected void COMPLETEList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<ActiveBookingListDto> oMaster = BookingMasterService.getCOMPLETEList(dataSource);
			request.setAttribute("DrvpendingList", oMaster);
			request.getRequestDispatcher("/CompleteBookingList.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}		
	}
	protected void CANCELEDist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<CancelBookingListDto> CancelList = BookingMasterService.getCANCELEDist(dataSource);
			request.setAttribute("CancelList", CancelList);
			request.getRequestDispatcher("/CancelBookings.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}		
	}
	
	protected void getCust(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("BookingID"));
		CustomerMaster oMaster = BookingMasterService.getCustInfo(dataSource, id);
		
		request.setAttribute("custinfo", oMaster);
		request.getRequestDispatcher("/DRideCustomerView.jsp").forward(request, response);
	}
	
	protected void Authorize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int DriverID =(int)session.getAttribute("DriverID");
		String VehicleNo =(String)session.getAttribute("VehicleNo"); 		
		int Bid = Integer.parseInt(request.getParameter("BookingID"));
		
		BookingMasterService.UpdateApprove(dataSource, Bid, DriverID, VehicleNo);
		mainList(request, response);
	}
	
	protected void Reject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int DriverID =(int)session.getAttribute("DriverID"); 	
		String VehicleNo =(String)session.getAttribute("VehicleNo"); 		
		int Bid = Integer.parseInt(request.getParameter("BookingID"));
		
		BookingMasterService.UpdateReject(dataSource, Bid, DriverID, VehicleNo);
		mainList(request, response);		
	}
}
