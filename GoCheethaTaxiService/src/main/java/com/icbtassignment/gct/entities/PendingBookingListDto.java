package com.icbtassignment.gct.entities;

import java.sql.Date;
import java.sql.Time;

import org.joda.time.DateTime;

public class PendingBookingListDto {
	private int BookingID;
	private String CustomerID;
	private String CityName;
	private String StreetName;
	private String PickUpLocation;
	private Date PickUpdate	;
	private Time PickUptime;
	private int VehicleType;
	private int Status;
	private Date CreateDateTime	;
	
	public PendingBookingListDto(int BookingID, String CustomerID, String CityName, String StreetName, String PickUpLocation,Date PickUpdate, Time PickUptime, 
			int VehicleType,int Status, Date CreateDateTime) {
		super();
		this.BookingID = BookingID;
		this.CustomerID = CustomerID;
		this.CityName = CityName;
		this.StreetName = StreetName;
		this.PickUpLocation = PickUpLocation;
		this.PickUpdate = PickUpdate;
		this.PickUptime = PickUptime;
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

	public String getPickUpLocation() {
		return PickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		PickUpLocation = pickUpLocation;
	}

	public Date getPickUpdate() {
		return PickUpdate;
	}

	public void setPickUpdate(Date pickUpdate) {
		PickUpdate = pickUpdate;
	}

	public Time getPickUptime() {
		return PickUptime;
	}

	public void setPickUptime(Time pickUptime) {
		PickUptime = pickUptime;
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

	public void setCreateDateTime(DateTime createDateTime) {
		CreateDateTime = createDateTime;
	}
	
	
}
