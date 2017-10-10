package dto;

import java.util.UUID;

public class Contact {
	
	private UUID id = null;
	private String firstName = null;
	private String lastName = null;
	private String address = null;
	private String mobileNumber = null;
	private String fixedNumber = null;
	private String email = null;
	
	public UUID getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getFixedNumber() {
		return fixedNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setFixedNumber(String fixedNumber) {
		this.fixedNumber = fixedNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
