package com.icbtassignment.gct.entities;

import java.sql.Date;

public class CancelBookingListDto {
	private int BookingID;
	private String CustomerID;
	private String DriverID;
	private String DriverName;
	private int VehicleType;
	private String VehicleNo;
	private int Status;
	private Date CreateDateTime;
	
	public CancelBookingListDto(int BookingID, String CustomerID, String DriverID, String DriverName,String VehicleNo, 
			int VehicleType,int Status, Date CreateDateTime) {
		super();
		this.BookingID = BookingID;
		this.CustomerID = CustomerID;
		this.DriverID = DriverID;
		this.DriverName = DriverName;
		this.VehicleNo = VehicleNo;
		this.VehicleType = VehicleType;
		this.Status = Status;
		this.CreateDateTime = CreateDateTime;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getDriverID() {
		return DriverID;
	}

	public void setDriverID(String driverID) {
		DriverID = driverID;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public int getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(int vehicleType) {
		VehicleType = vehicleType;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public Date getCreateDateTime() {
		return CreateDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		CreateDateTime = createDateTime;
	}
	
	
}
