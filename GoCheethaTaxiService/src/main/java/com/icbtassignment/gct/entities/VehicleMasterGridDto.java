package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class VehicleMasterGridDto {

	private String VehicleNo;
	
	private int VehicleType;
	
	private String VehicleOwnerName;
	
	private int BranchID;
	
	private String BranchLocation;
	
	private Float AmountperKM;

	private int Status;

	private DateTime CreateDatetime;
	
	private DateTime ModifiedDateTime;
	
	public VehicleMasterGridDto(String VehicleNo, int VehicleType, String VehicleOwnerName, int BranchID, String BranchLocation,Float AmountperKM, int Status, DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.VehicleNo = VehicleNo;
		this.VehicleType = VehicleType;
		this.VehicleOwnerName = VehicleOwnerName;
		this.BranchID = BranchID;
		this.BranchLocation = BranchLocation;
		this.AmountperKM = AmountperKM;
		this.Status = Status;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
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

	public String getVehicleOwnerName() {
		return VehicleOwnerName;
	}

	public void setVehicleOwnerName(String vehicleOwnerName) {
		VehicleOwnerName = vehicleOwnerName;
	}

	public int getBranchID() {
		return BranchID;
	}

	public void setBranchID(int branchID) {
		BranchID = branchID;
	}

	public String getBranchLocation() {
		return BranchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		BranchLocation = branchLocation;
	}

	public Float getAmountperKM() {
		return AmountperKM;
	}

	public void setAmountperKM(Float amountperKM) {
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

}
