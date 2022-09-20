package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class ServiceCharge {

	@NotBlank(message = "is required")
	private int VehicleType ;
	
	@NotBlank(message = "is required")
	private String Amount ;
	
	private DateTime CreateDateTime;
	
	private DateTime ModifiedDateTime;
	
	public ServiceCharge(int VehicleType, String Amount) {
		this.VehicleType = VehicleType;
		this.Amount = Amount;
	}
	
	public ServiceCharge(int VehicleType, String Amount,DateTime CreateDateTime, DateTime ModifiedDateTime) {
		super();
		this.VehicleType = VehicleType;
		this.Amount = Amount;
		this.CreateDateTime = CreateDateTime;
		this.ModifiedDateTime = ModifiedDateTime;
	}

	public int getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(int vehicleType) {
		VehicleType = vehicleType;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public DateTime getCreateDateTime() {
		return CreateDateTime;
	}

	public void setCreateDateTime(DateTime createDateTime) {
		CreateDateTime = createDateTime;
	}

	public DateTime getModifiedDateTime() {
		return ModifiedDateTime;
	}

	public void setModifiedDateTime(DateTime modifiedDateTime) {
		ModifiedDateTime = modifiedDateTime;
	}
	
	
	
}
