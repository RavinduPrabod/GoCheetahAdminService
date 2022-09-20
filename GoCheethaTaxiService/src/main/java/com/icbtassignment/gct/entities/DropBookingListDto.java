package com.icbtassignment.gct.entities;

import org.joda.time.DateTime;

public class DropBookingListDto {
	private int BookingID;
	private int DriverID;
	private String VehicleNo;
	private float AmountperKM;
	private String TotalKM;
	private String ServiceCharge;
	private int Status;
	private DateTime CreateDatetime;
	private DateTime ModifiedDateTime;
	
	public DropBookingListDto(int BookingID,int DriverID, String VehicleNo, float AmountperKM,
			int Status, DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.BookingID = BookingID;
		this.DriverID = DriverID;
		this.VehicleNo = VehicleNo;
		this.AmountperKM = AmountperKM;
		this.Status = Status;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}
	
	public DropBookingListDto(int BookingID,int DriverID, String VehicleNo, float AmountperKM,String TotalKM, String ServiceCharge,
			int Status, DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.BookingID = BookingID;
		this.DriverID = DriverID;
		this.VehicleNo = VehicleNo;
		this.AmountperKM = AmountperKM;
		this.TotalKM = TotalKM;
		this.ServiceCharge = ServiceCharge;
		this.Status = Status;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}
	
	public DropBookingListDto(int BookingID,int DriverID, String VehicleNo, float AmountperKM) {
		this.BookingID = BookingID;
		this.DriverID = DriverID;
		this.VehicleNo = VehicleNo;
		this.AmountperKM = AmountperKM;
	}
	
	public DropBookingListDto(int BookingID,int DriverID, String VehicleNo) {
		this.BookingID = BookingID;
		this.DriverID = DriverID;
		this.VehicleNo = VehicleNo;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
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

	public float getAmountperKM() {
		return AmountperKM;
	}

	public void setAmountperKM(float amountperKM) {
		AmountperKM = amountperKM;
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

	public String getTotalKM() {
		return TotalKM;
	}

	public void setTotalKM(String totalKM) {
		TotalKM = totalKM;
	}

	public String getServiceCharge() {
		return ServiceCharge;
	}

	public void setServiceCharge(String serviceCharge) {
		ServiceCharge = serviceCharge;
	}
	
	
}
