package com.hcl.busbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.busbooking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	

}
