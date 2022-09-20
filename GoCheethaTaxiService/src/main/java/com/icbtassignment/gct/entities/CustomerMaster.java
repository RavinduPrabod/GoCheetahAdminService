package com.icbtassignment.gct.entities;


import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class CustomerMaster {
	
	private String CustomerID;
	
	@NotBlank(message = "is required")
	private String FirstName;
	
	@NotBlank(message = "is required")
	private String LastName;
	
	@NotBlank(message = "is required")
	private String Email;
	
	@NotBlank(message = "is required")
	private String MobileNo;
	
	@NotBlank(message = "is required")
	private String City;
	
	private DateTime CreateDateTime;
	
	private DateTime ModifiedDateTime;
	
	private int BookingID;

	public CustomerMaster(String CustomerID, String FirstName, String City,String MobileNo, String Email, int BookingID) {
		this.CustomerID = CustomerID;
		this.FirstName = FirstName;
		this.City = City;
		this.MobileNo = MobileNo;
		this.Email = Email;
		this.BookingID = BookingID;
	}

	public CustomerMaster(String CustomerID, String FirstName, String LastName, String City,String MobileNo, String Email) {
		super();
		this.CustomerID = CustomerID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Email = Email;
		this.MobileNo = MobileNo;
		this.City = City;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
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

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}

	
}
