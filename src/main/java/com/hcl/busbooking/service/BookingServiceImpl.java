package com.hcl.busbooking.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.busbooking.dao.BookingRepository;
import com.hcl.busbooking.dto.BookingDto;
import com.hcl.busbooking.exception.NoSeatAvailableException;
import com.hcl.busbooking.model.Booking;
@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingRepository bookingRepository;
	
	 BookingDto dto=new BookingDto();	

	@Override
	public BookingDto bookTheSeat(Booking booking) throws NoSeatAvailableException {
		Booking booking1=bookingRepository.save(booking);
		 dto.setBusName(booking1.getBusroute().getBusName());
		 dto.setBusServiceNumber(booking1.getBusroute().getBusServiceNumber());
		 dto.setNoOfSeats(booking1.getNoOfSeats());
			return dto;
		
		
	}
	

}
