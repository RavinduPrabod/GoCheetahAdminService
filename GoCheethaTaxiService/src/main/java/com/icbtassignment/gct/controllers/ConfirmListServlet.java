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

import com.icbtassignment.gct.entities.CustomerMaster;
import com.icbtassignment.gct.entities.DRidePendingListDto;
import com.icbtassignment.gct.entities.DropBookingListDto;
import com.icbtassignment.gct.services.BookingMasterService;

@WebServlet("/ConfirmListServlet")
public class ConfirmListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmListServlet() {
		super();
	}

	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command == null) {
			mainList(request, response);

		} else if (command.equals("VIEWINFO")) {
			getCust(request, response);
			command = null;
		} else if (command.equals("ONWAY")) {
			ONWAY(request, response);
		} else if (command.equals("PICK")) {
			PICK(request, response);
		} else if (command.equals("DROP")) {
			DROP(request, response);
		} else if (command.equals("COMPLETE")) {
			COMPLETE(request, response);
		} else if (command.equals("REJECT")) {
			Reject(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");

		if (command == null) {
			mainList(request, response);

		} else if (command.equals("VIEWINFO")) {
			getCust(request, response);
			command = null;
		} else if (command.equals("ONWAY")) {
			ONWAY(request, response);
		} else if (command.equals("PICK")) {
			PICK(request, response);
		} else if (command.equals("DROP")) {
			DROP(request, response);
		}

	}

	protected void mainList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			int DriverID = (int) session.getAttribute("DriverID");

			List<DRidePendingListDto> oMaster = BookingMasterService.getConfirmList(dataSource, DriverID);
			request.setAttribute("DrvpendingList", oMaster);
			request.getRequestDispatcher("/DRideApproveList.jsp").forward(request, response);

		} catch (Exception e) {
			throw e;
		}

	}

	protected void getCust(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("BookingID"));
		CustomerMaster oMaster = BookingMasterService.getCustInfo(dataSource, id);

		List<DRidePendingListDto> oMasterlist = BookingMasterService.getDrvpendingList(dataSource);
		request.setAttribute("DrvpendingList", oMasterlist);

		request.setAttribute("custinfo", oMaster);
		request.getRequestDispatcher("/DRideApproveList.jsp").forward(request, response);
	}

	protected void ONWAY(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("BookingID"));
		BookingMasterService.UpdateONWAY(dataSource, id);
		mainList(request, response);
	}

	protected void PICK(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("BookingID"));
		BookingMasterService.UpdatePICK(dataSource, id);
		mainList(request, response);
	}

	protected void DROP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("BookingID"));
		int amountperKM = Integer.parseInt(request.getParameter("amountperKM"));
		int KMCovered = Integer.parseInt(request.getParameter("KMCovered"));
		String ServiceCharge = request.getParameter("amount");
		String total = String.valueOf(amountperKM * KMCovered);
		DropBookingListDto droplist = BookingMasterService.getBookingDetails(dataSource, id);
		BookingMasterService.UpdateDROP(dataSource, droplist, ServiceCharge, KMCovered, total);
		mainList(request, response);
	}

	protected void COMPLETE(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			int DriverID = (int) session.getAttribute("DriverID");

			List<DRidePendingListDto> oMaster = BookingMasterService.getDriverComplteList(dataSource, DriverID);
			request.setAttribute("DrvpendingList", oMaster);
			request.getRequestDispatcher("/BookingHistory.jsp").forward(request, response);

		} catch (Exception e) {
			throw e;
		}
	}

	protected void Reject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int DriverID = (int) session.getAttribute("DriverID");
		String VehicleNo = (String) session.getAttribute("VehicleNo");
		int Bid = Integer.parseInt(request.getParameter("BookingID"));

		BookingMasterService.UpdateRejectAfterConfirm(dataSource, Bid, DriverID, VehicleNo);
		mainList(request, response);
	}

}
