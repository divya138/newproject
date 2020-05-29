package com.hcl.busbooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.busbooking.dto.BookingDto;
import com.hcl.busbooking.exception.NoSeatAvailableException;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.model.BusRoute;
import com.hcl.busbooking.model.User;
import com.hcl.busbooking.service.BookingServiceImpl;
@RunWith(MockitoJUnitRunner.Silent.class)
public class BookingControllerTest {
	@InjectMocks
	BookingController bookingController;
	@Mock
	BookingServiceImpl bookingServiceImpl;
	
	static User user=null;
	static Booking booking=null;
	static BookingDto bookingDto=null;
	static List<Booking> bookings=new ArrayList<Booking>();
	static BusRoute busRoute=null;
	@BeforeClass
	public static void setUp() {
		user=new User();
		booking=new Booking();
		user.setUserId(1);
		user.setEmail("bhavani");
		booking.setBookingId(2);
		booking.setBusroute(busRoute);
		booking.setUser(user);
		bookings.add(booking);
	}
	@Test
	public void testMyBooking() {
		
		Mockito.when(bookingServiceImpl.bookTheSeat(booking)).thenReturn(bookingDto);
		bookingController.bookingtheTicket(booking);
		
	}
	@Test
	public void testSaveTicketForNegitive(){
		Mockito.when(bookingServiceImpl.bookTheSeat(booking)).thenReturn((bookingDto));
		ResponseEntity<BookingDto> resTicket = bookingController.bookingtheTicket(booking);
		Assert.assertNotNull(resTicket);
	}

	@Test
	public void testSaveTicketForPostive(){
		Mockito.when(bookingServiceImpl.bookTheSeat(booking)).thenReturn((bookingDto));
		ResponseEntity<BookingDto> resTicket = bookingController.bookingtheTicket(booking);
		Assert.assertNotNull(resTicket);
	}
	@Test(expected = NullPointerException.class)
	public void testSaveTicketForException() throws NoSeatAvailableException  {
		Mockito.when(bookingServiceImpl.bookTheSeat(booking)).thenThrow(NullPointerException.class);
		ResponseEntity<BookingDto> resTicket = bookingController.bookingtheTicket(booking);
	}
}
