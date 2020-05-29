package com.hcl.busbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.busbooking.dao.BookingRepository;
import com.hcl.busbooking.dto.BookingDto;
import com.hcl.busbooking.exception.NoSeatAvailableException;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.model.BusRoute;
@RunWith(MockitoJUnitRunner.Silent.class)
public class BookingServieTest {
	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	@Mock
	BookingRepository bookingRepository;
	
	static Booking booking = null;
	static BusRoute route=null;

	@BeforeClass
	public static void setUp() {
		booking = new Booking();
		route=new BusRoute();

	}

	@Before
	public void beforeMethod() {
		booking.setBookingId(12);
		booking.setMobileNumber(51671671);
		booking.setUserName("sam");
		route.setBusName("kaveri");
		route.setBusServiceNumber(323);
		booking.setBusroute(route);
	}
	
	@Test
	public void testbookTheTicket() {
		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		BookingDto s1 = bookingServiceImpl.bookTheSeat(booking);
		Assert.assertNotEquals("kaveri1", s1.getBusName());
	}
	@Test
	public void testaddBookingNe() {
		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		BookingDto s1 = bookingServiceImpl.bookTheSeat(booking);
		Assert.assertEquals("kaveri", s1.getBusName());
	}
	@Test(expected = NullPointerException.class)
	public void testSaveTicketForException() throws NoSeatAvailableException  {
		Mockito.when(bookingRepository.save(booking)).thenThrow(NullPointerException.class);
		BookingDto s1 = bookingServiceImpl.bookTheSeat(booking);
	}
	
}
