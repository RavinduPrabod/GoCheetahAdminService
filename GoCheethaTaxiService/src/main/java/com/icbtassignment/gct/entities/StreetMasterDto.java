package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class StreetMasterDto {
	
	private int StreetID;
	
	@NotBlank(message = "is required")
	private String 	StreetName;
	
	private int CityID;
	
	private String CityName;
	
	private DateTime CreateDateTime;
	
	private DateTime ModifiedDateTime;
	
	public StreetMasterDto(int StreetID, String StreetName, int CityID, String CityName) {
		this.StreetID =StreetID;
		this.StreetName = StreetName;
		this.CityID = CityID;
		this.CityName = CityName;
	}
	
	public StreetMasterDto(int StreetID, String StreetName, int CityID, DateTime CreateDateTime, DateTime ModifiedDateTime) {
		super();
		this.StreetID = StreetID;
		this.StreetName = StreetName;
		this.CityID = CityID;
		this.CreateDateTime = CreateDateTime;
		this.ModifiedDateTime = ModifiedDateTime;
	}

	public int getStreetID() {
		return StreetID;
	}

	public void setStreetID(int streetID) {
		StreetID = streetID;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
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
