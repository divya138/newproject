package com.hcl.busbooking.service;

import java.util.List;

import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.dto.UserDto;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.model.User;

public interface UserService {
	
	public List<Booking> myBookings(int userId);
	public ResponseMessage registration(UserDto userDto);
	public User UpdateUser(User user2) ;
 
}
