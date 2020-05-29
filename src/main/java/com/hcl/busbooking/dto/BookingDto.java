package com.hcl.busbooking.dto;

public class BookingDto {
	private String busName;
	private int busServiceNumber;
	private int noOfSeats;
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getBusServiceNumber() {
		return busServiceNumber;
	}
	public void setBusServiceNumber(int busServiceNumber) {
		this.busServiceNumber = busServiceNumber;
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public BookingDto(String busName, int busServiceNumber, int noOfSeats) {
		super();
		this.busName = busName;
		this.busServiceNumber = busServiceNumber;
		this.noOfSeats = noOfSeats;
	}
	public BookingDto() {
		super();
		
	}
	
	
	

}
