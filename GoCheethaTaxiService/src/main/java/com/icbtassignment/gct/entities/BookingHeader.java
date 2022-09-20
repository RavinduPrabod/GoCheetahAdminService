package com.icbtassignment.gct.entities;

import org.joda.time.DateTime;

public class BookingHeader {
	private int BookingID;
	private String CustomerID;
	private int CityID;
	private int StreetID;
	private int DriverID;
	private String VehicleNo;
	private int VehicleType;
	private int Status;
	private DateTime CreateDatetime;
	private DateTime ModifiedDateTime;
	
	public BookingHeader(int BookingID, String CustomerID, int CityID, int StreetID,int DriverID, String VehicleNo, int VehicleType,
			int Status, DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.BookingID = BookingID;
		this.CustomerID = CustomerID;
		this.CityID = CityID;
		this.StreetID = StreetID;
		this.DriverID = DriverID;
		this.VehicleNo = VehicleNo;
		this.VehicleType = VehicleType;
		this.Status = Status;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
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

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

	public int getStreetID() {
		return StreetID;
	}

	public void setStreetID(int streetID) {
		StreetID = streetID;
	}

	public int getDriverID() {
		return DriverID;
	}

	public void setDriverID(int driverID) {
		DriverID = driverID;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public int getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(int vehicleType) {
		VehicleType = vehicleType;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public DateTime getCreateDatetime() {
		return CreateDatetime;
	}

	public void setCreateDatetime(DateTime createDatetime) {
		CreateDatetime = createDatetime;
	}

	public DateTime getModifiedDateTime() {
		return ModifiedDateTime;
	}

	public void setModifiedDateTime(DateTime modifiedDateTime) {
		ModifiedDateTime = modifiedDateTime;
	}
	
}
