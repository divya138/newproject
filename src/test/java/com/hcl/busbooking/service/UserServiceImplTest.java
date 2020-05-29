package com.hcl.busbooking.service;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import com.hcl.busbooking.dao.UserRepository;
import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.dto.UserDto;
import com.hcl.busbooking.exception.UserNotFoundException;
import com.hcl.busbooking.model.User;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {
	@Mock
	UserRepository userRepository;
	@InjectMocks
	UserServiceImpl userServiceImpl;
	static User user=null;
	static UserDto dto=null;
	@BeforeClass
	public static void setUp() {
		
		user=new User();
		dto=new UserDto();
		user.setFirstName("bhavani");
		user.setPassword("bhavani123");
		dto.setFirstName("bhavani");
		dto.setPassword("bhavani123");
		BeanUtils.copyProperties(dto, user);
		
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUserRegestration() {
		UserDto dto=new UserDto();
		ResponseMessage message=new ResponseMessage();
		dto.setFirstName("bhavani");
		dto.setPassword("bhavani123");
		user.setFirstName("bhavani");
		user.setPassword("bhavani123");
		BeanUtils.copyProperties(dto, user);
		message.setMessage("registration done");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		userServiceImpl.registration(dto);
	
	}

	@Test(expected = NullPointerException.class)
	public void testSaveForNegitive() throws UserNotFoundException {
		User user=new User();
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenThrow(NullPointerException.class);
		User resUser = userServiceImpl.UpdateUser(user);
	}
	
	@Test(expected = Exception.class)
	public void testgetUserForExce(){
		UserDto userDto = new UserDto();
		User user=new User();
		Mockito.when(userRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword())).thenThrow(Exception.class);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUserRegestrationPos() {
		UserDto dto=new UserDto();
		ResponseMessage message=new ResponseMessage();
		dto.setFirstName("bhavani");
		dto.setPassword("bhavani123");
		user.setFirstName("bhavani");
		user.setPassword("bhavani123");
		BeanUtils.copyProperties(dto, user);
		message.setMessage("registration done");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		userServiceImpl.registration(dto);
	
	}

}
