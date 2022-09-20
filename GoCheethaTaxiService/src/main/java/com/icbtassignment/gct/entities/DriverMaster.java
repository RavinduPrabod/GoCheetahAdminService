package com.icbtassignment.gct.entities;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class DriverMaster {

	private int DriverID;
	
	@NotBlank(message = "is required")
	private String DriverName;
	
	@NotBlank(message = "is required")
	private String ContactNo;
	
	@NotBlank(message = "is required")
	private String NIC;
	
	@NotBlank(message = "is required")
	private String LicenseNo;
	
	@NotBlank(message = "is required")
	private String VehicleNo;
	
	@NotBlank(message = "is required")
	private int Status;
	
	@NotBlank(message = "is required")
	private int BranchID;
	
	private String UserName;
	
	private String Password;
	
	private String BranchLocation;
	
	private DateTime CreateDatetime;
	
	private DateTime ModifiedDateTime;
	
	public DriverMaster(int DriverID, String DriverName,String ContactNo, String NIC, String LicenseNo, int BranchID, String VehicleNo, String UserName, String Password, int Status, DateTime CreateDatetime, DateTime ModifiedDateTime) {
		this.DriverID = DriverID;
		this.DriverName = DriverName;
		this.ContactNo = ContactNo;
		this.NIC = NIC;
		this.LicenseNo = LicenseNo;
		this.Status = Status;
		this.BranchID = BranchID;
		this.VehicleNo = VehicleNo;
		this.UserName = UserName;
		this.Password = Password;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}
	
	public DriverMaster(int DriverID, String DriverName,String ContactNo, String NIC, String LicenseNo,int Status,int BranchID,float AmountperKM, DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.DriverID = DriverID;
		this.DriverName = DriverName;
		this.NIC = NIC;
		this.LicenseNo = LicenseNo;
		this.Status = Status;
		this.BranchID = BranchID;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}
	
	public DriverMaster(int DriverID, String DriverName, String VehicleNo) {
		super();
		this.DriverID = DriverID;
		this.DriverName = DriverName;
		this.VehicleNo = VehicleNo;
	}

	public int getDriverID() {
		return DriverID;
	}

	public void setDriverID(int driverID) {
		DriverID = driverID;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getLicenseNo() {
		return LicenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		LicenseNo = licenseNo;
	}

	public int getStatus() {
		return Status;
	}

	public int getBranchID() {
		return BranchID;
	}

	public void setBranchID(int branchID) {
		BranchID = branchID;
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

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public String getBranchLocation() {
		return BranchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		BranchLocation = branchLocation;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	

}
