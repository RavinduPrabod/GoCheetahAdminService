package com.icbtassignment.gct.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.joda.time.DateTime;

import com.icbtassignment.gct.entities.CustomerMaster;
import com.icbtassignment.gct.services.CityMasterServices;
import com.icbtassignment.gct.services.CustomerMasterService;
import com.icbtassignment.gct.utils.EntityValidator;

@WebServlet("/CustomerMasterServlet")
public class CustomerMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name ="jdbc/gocheetha_application")
    private DataSource dataSource;
	
    public CustomerMasterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainList(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void mainList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<CustomerMaster> oCustomerMaster = CustomerMasterService.getList(dataSource);
		request.setAttribute("CustomerList", oCustomerMaster);
		request.getRequestDispatcher("/CustomerMasterList.jsp").forward(request, response);
	}
	
}
