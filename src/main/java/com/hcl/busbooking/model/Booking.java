package com.hcl.busbooking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String userName;
	private Gender gender;
	private long mobileNumber;
	private int noOfSeats;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="busServiceNumber")
	private BusRoute busroute;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	@JsonIgnore
	private User user;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public BusRoute getBusroute() {
		return busroute;
	}
	public void setBusroute(BusRoute busroute) {
		this.busroute = busroute;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(String userName, Gender gender, long mobileNumber, int noOfSeats, BusRoute busroute, User user) {
		super();
		this.userName = userName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.noOfSeats = noOfSeats;
		this.busroute = busroute;
		this.user = user;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	

}
