package com.icbtassignment.gct.entities;

import java.sql.Date;

public class DRidePendingListDto {
	
	private int BookingID;
	private String CityName;
	private String StreetName;
	private String PickUpLocation;
	private Date PickUpdate	;
	private String PickUptime;
	private int Status;
	private String AmountperKM;
	private String Amount;
	
	public DRidePendingListDto(int BookingID, String CityName, String StreetName, String AmountperKM, String PickUpLocation,Date PickUpdate, String PickUptime, int Status) {
		super();
		this.BookingID = BookingID;
		this.CityName = CityName;
		this.StreetName = StreetName;
		this.PickUpLocation = PickUpLocation;
		this.PickUpdate = PickUpdate;
		this.PickUptime = PickUptime;
		this.Status = Status;
		this.AmountperKM = AmountperKM;
	}
	public DRidePendingListDto(int BookingID, String CityName, String StreetName, String AmountperKM, String Amount, String PickUpLocation,Date PickUpdate, String PickUptime, int Status) {
		super();
		this.BookingID = BookingID;
		this.CityName = CityName;
		this.StreetName = StreetName;
		this.PickUpLocation = PickUpLocation;
		this.PickUpdate = PickUpdate;
		this.PickUptime = PickUptime;
		this.Status = Status;
		this.AmountperKM = AmountperKM;
		this.Amount = Amount;
	}
	
	public DRidePendingListDto(int BookingID, String CityName, String StreetName, String PickUpLocation,Date PickUpdate, String PickUptime, int Status) {
		super();
		this.BookingID = BookingID;
		this.CityName = CityName;
		this.StreetName = StreetName;
		this.PickUpLocation = PickUpLocation;
		this.PickUpdate = PickUpdate;
		this.PickUptime = PickUptime;
		this.Status = Status;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
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

	public String getPickUptime() {
		return PickUptime;
	}

	public void setPickUptime(String pickUptime) {
		PickUptime = pickUptime;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getAmountperKM() {
		return AmountperKM;
	}

	public void setAmountperKM(String amountperKM) {
		AmountperKM = amountperKM;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	
}
