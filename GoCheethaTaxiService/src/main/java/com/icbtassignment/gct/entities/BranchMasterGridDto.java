package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class BranchMasterGridDto {
	@NotBlank(message = "is required")
	private int CityID;
	
	@NotBlank(message = "is required")
	private int BranchID;
	
	@NotBlank(message = "is required")
	private String BranchLocation;
	
	private DateTime CreateDatetime;
	
	private DateTime ModifiedDateTime;
	
	private String CityName;
	
	public BranchMasterGridDto(int CityID, int BranchID, String BranchLocation, String CityName) {
		this.CityID = CityID;
		this.BranchID = BranchID;
		this.BranchLocation = BranchLocation;
		this.CityName=CityName;
	}

	
	public BranchMasterGridDto(int BranchID, String BranchLocation, DateTime CreateDatetime, DateTime ModifiedDateTime ) {
		super();
		this.BranchID = BranchID;
		this.BranchLocation = BranchLocation;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
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

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}
	
}


