package com.icbtassignment.gct.entities;

import java.sql.Date;

public class ActiveBookingListDto {
	private int BookingID;
	private String CustomerID;
	private String CityName;
	private String StreetName;
	private String DriverName;
	private String VehicleNo;
	private int VehicleType;
	private int Status;
	private Date CreateDateTime	;
	
	public ActiveBookingListDto(int BookingID, String CustomerID, String CityName, String StreetName, String DriverName,String VehicleNo, 
			int VehicleType,int Status, Date CreateDateTime) {
		super();
		this.BookingID = BookingID;
		this.CustomerID = CustomerID;
		this.CityName = CityName;
		this.StreetName = StreetName;
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

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
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

	public Date getCreateDateTime() {
		return CreateDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		CreateDateTime = createDateTime;
	}

}
