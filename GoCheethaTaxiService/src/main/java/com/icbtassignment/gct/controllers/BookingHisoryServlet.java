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

import com.icbtassignment.gct.entities.CustomerMaster;
import com.icbtassignment.gct.entities.DRidePendingListDto;
import com.icbtassignment.gct.services.BookingMasterService;


@WebServlet("/BookingHisoryServlet")
public class BookingHisoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookingHisoryServlet() {
        super();
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
    	}
    	
    	protected void mainList(HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException {
    		try {
    			List<DRidePendingListDto> oMaster = BookingMasterService.getComplteList(dataSource);
    			request.setAttribute("DrvpendingList", oMaster);
    			request.getRequestDispatcher("/BookingHistory.jsp").forward(request, response);
    			
    		} catch (Exception e) {
    			throw e;
    		}
    		
    	}
    	
    	protected void getCust(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		int id = Integer.parseInt(request.getParameter("BookingID"));
    		CustomerMaster oMaster = BookingMasterService.getCustInfo(dataSource, id);
    		
    		List<DRidePendingListDto> oMasterlist = BookingMasterService.getDrvpendingList(dataSource);
    		request.setAttribute("DrvpendingList", oMasterlist);
    		
    		
    		request.setAttribute("custinfo", oMaster);
    		request.getRequestDispatcher("/BookingHistory.jsp").forward(request, response);
    	}

}
