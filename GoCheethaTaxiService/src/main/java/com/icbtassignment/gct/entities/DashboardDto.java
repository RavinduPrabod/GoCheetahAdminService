package com.icbtassignment.gct.entities;

public class DashboardDto {

	private String PendingCount;
	private String ActiveCount;
	private String CompleteCount;
	private String Revenue;
	private String CustomerCount;
	private String DriverCount;
	private String VehicleCount;
	private String BranchCount;
	private String CancelCount;
	private String UserCount;
	
	public DashboardDto(String PendingCount, String ActiveCount,String CompleteCount,String Revenue, String CustomerCount,String DriverCount,String VehicleCount,String BranchCount,String CancelCount, String UserCount) {
		super();
		this.PendingCount = PendingCount;
		this.ActiveCount = ActiveCount;
		this.CompleteCount = CompleteCount;
		this.Revenue = Revenue;
		this.CustomerCount = CustomerCount;
		this.DriverCount = DriverCount;
		this.VehicleCount = VehicleCount;
		this.BranchCount = BranchCount;
		this.CancelCount = CancelCount;
		this.UserCount = UserCount;
	}
	
	public DashboardDto(String PendingCount, String ActiveCount,String CompleteCount,String CancelCount,String Revenue) {
		this.PendingCount = PendingCount;
		this.ActiveCount = ActiveCount;
		this.CompleteCount = CompleteCount;
		this.CancelCount = CancelCount;
		this.Revenue = Revenue;
	}

	public String getPendingCount() {
		return PendingCount;
	}

	public void setPendingCount(String pendingCount) {
		PendingCount = pendingCount;
	}

	public String getActiveCount() {
		return ActiveCount;
	}

	public void setActiveCount(String activeCount) {
		ActiveCount = activeCount;
	}

	public String getCompleteCount() {
		return CompleteCount;
	}

	public void setCompleteCount(String completeCount) {
		CompleteCount = completeCount;
	}

	public String getRevenue() {
		return Revenue;
	}

	public void setRevenue(String revenue) {
		Revenue = revenue;
	}

	public String getCustomerCount() {
		return CustomerCount;
	}

	public void setCustomerCount(String customerCount) {
		CustomerCount = customerCount;
	}

	public String getDriverCount() {
		return DriverCount;
	}

	public void setDriverCount(String driverCount) {
		DriverCount = driverCount;
	}

	public String getVehicleCount() {
		return VehicleCount;
	}

	public void setVehicleCount(String vehicleCount) {
		VehicleCount = vehicleCount;
	}

	public String getBranchCount() {
		return BranchCount;
	}

	public void setBranchCount(String branchCount) {
		BranchCount = branchCount;
	}

	public String getCancelCount() {
		return CancelCount;
	}

	public void setCancelCount(String cancelCount) {
		CancelCount = cancelCount;
	}

	public String getUserCount() {
		return UserCount;
	}

	public void setUserCount(String userCount) {
		UserCount = userCount;
	}	
	
}
