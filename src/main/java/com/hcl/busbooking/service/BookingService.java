package com.hcl.busbooking.service;

import com.hcl.busbooking.dto.BookingDto;
import com.hcl.busbooking.exception.NoSeatAvailableException;
import com.hcl.busbooking.model.Booking;

public interface BookingService {
	
	public BookingDto bookTheSeat(Booking booking)throws NoSeatAvailableException;

}
