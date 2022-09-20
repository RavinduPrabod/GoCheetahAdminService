package com.icbtassignment.gct.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gct.dao.BookingMasterDao;
import com.icbtassignment.gct.entities.ActiveBookingListDto;
import com.icbtassignment.gct.entities.CancelBookingListDto;
import com.icbtassignment.gct.entities.CustomerMaster;
import com.icbtassignment.gct.entities.DRidePendingListDto;
import com.icbtassignment.gct.entities.DropBookingListDto;
import com.icbtassignment.gct.entities.PendingBookingListDto;

public class BookingMasterService {

	public static List<DRidePendingListDto> getDrvpendingList(DataSource dataSource) {
		return BookingMasterDao.getDrvpendingList(dataSource);
	}

	public static List<PendingBookingListDto> getAdpendingList(DataSource dataSource) {
		return BookingMasterDao.getAdpendingList(dataSource);
	}

	public static List<ActiveBookingListDto> getAdActiveList(DataSource dataSource) {
		return BookingMasterDao.getAdActiveList(dataSource);
	}

	public static List<ActiveBookingListDto> getCOMPLETEList(DataSource dataSource) {
		return BookingMasterDao.getCOMPLETEList(dataSource);
	}
	
	public static List<CancelBookingListDto> getCANCELEDist(DataSource dataSource) {
		return BookingMasterDao.getCANCELEDist(dataSource);
	}
	
	public static List<DRidePendingListDto> getConfirmList(DataSource dataSource, int DriverID) {
		return BookingMasterDao.getActiveList(dataSource, DriverID);
	}

	public static List<DRidePendingListDto> getComplteList(DataSource dataSource) {
		return BookingMasterDao.getComplteList(dataSource);
	}

	public static List<DRidePendingListDto> getDriverComplteList(DataSource dataSource, int DriverID) {
		return BookingMasterDao.getDriverComplteList(dataSource, DriverID);
	}

	public static CustomerMaster getCustInfo(DataSource dataSource, int id) {
		return BookingMasterDao.getCustInfo(dataSource, id);
	}

	public static DropBookingListDto getBookingDetails(DataSource dataSource, int BID) {
		return BookingMasterDao.getBookingDetails(dataSource, BID);
	}

	public static void UpdateApprove(DataSource dataSource, int id, int DriverID, String VehicleNo) {
		BookingMasterDao.InsertBookingHeader(dataSource, id, DriverID, VehicleNo);
		BookingMasterDao.UpdateStatusDetails(dataSource, id, 2);
	}

	public static void UpdateReject(DataSource dataSource, int id, int DriverID, String VehicleNo) {
		BookingMasterDao.InsertBookingRejectList(dataSource, id, DriverID, VehicleNo);
		BookingMasterDao.UpdateStatusDetails(dataSource, id, 0);
	}
	public static void UpdateRejectAfterConfirm(DataSource dataSource, int id, int DriverID, String VehicleNo) {
		BookingMasterDao.InsertBookingRejectList(dataSource, id, DriverID, VehicleNo);
		BookingMasterDao.UpdateStatusDetails(dataSource, id, 0);
		BookingMasterDao.UpdateStatusHeader(dataSource, id, 0);
	}

	public static void UpdateONWAY(DataSource dataSource, int id) {
		BookingMasterDao.UpdateStatusHeader(dataSource, id, 3);
	}

	public static void UpdatePICK(DataSource dataSource, int id) {
		BookingMasterDao.UpdateStatusHeader(dataSource, id, 4);
	}

	public static void UpdateDROP(DataSource dataSource, DropBookingListDto droplist, String ServiceCharge, int KMCovered , String total ) {
		BookingMasterDao.InsertBookingDropList(dataSource, droplist, ServiceCharge, KMCovered, total);
		BookingMasterDao.UpdateStatusHeader(dataSource, droplist.getBookingID(), 5);
	}
}
