package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class VehicleMaster {
	
	private String VehicleNo;
	
	@NotBlank(message = "is required")
	private int VehicleType;
	
	@NotBlank(message = "is required")
	private String VehicleOwnerName;
	
	@NotBlank(message = "is required")
	private int BranchID;;
	
	@NotBlank(message = "is required")
	private Float AmountperKM;;
	
	@NotBlank(message = "is required")
	private int Status;

	private DateTime CreateDatetime;
	
	private DateTime ModifiedDateTime;
	
	public VehicleMaster(String VehicleNo, int VehicleType, String VehicleOwnerName, int BranchID, Float AmountperKM, int Status, DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.VehicleNo = VehicleNo;
		this.VehicleType = VehicleType;
		this.VehicleOwnerName = VehicleOwnerName;
		this.BranchID = BranchID;
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
