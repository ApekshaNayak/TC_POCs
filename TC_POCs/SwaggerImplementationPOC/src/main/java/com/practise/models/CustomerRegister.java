package com.practise.models;

public class CustomerRegister {
	 private String firstName;
	 private String lastName;
	 private String streetAddress;
	 private String city;
	 
	@Override
	public String toString() {
		return "CustomerRegister [firstName=" + firstName + ", lastName=" + lastName + ", streetAddress="
				+ streetAddress + ", city=" + city + "]";
	}
	
	public CustomerRegister() {
		super();
	}

	public CustomerRegister(String firstName, String lastName, String streetAddress, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
