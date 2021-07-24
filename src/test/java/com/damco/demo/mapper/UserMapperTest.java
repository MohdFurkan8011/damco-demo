package com.damco.demo.mapper;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.damco.demo.dto.UserDTO;
import com.damco.demo.model.User;
import com.damco.demo.params.UserParam;

class UserMapperTest {
	
	private User user;
	private UserParam userParam;
	
	@BeforeEach
	public void init() {
		
		user 		= new User("60f96420c6f7bb1290c6ec26", "Mr.", "ABC", "Java Developer", LocalDate.now());
		userParam 	= new UserParam("Mr.", "XYZ", "Java Developer", LocalDate.now());
	}
	
	@Test
	void mapToUserWithUserParamOnlyTest() {
		
		User 	user			= UserMapper.mapToUser(userParam);
		boolean isFirstNameSame = user.getFirstName().equals(userParam.getFirstName());
		assertTrue(isFirstNameSame);
	}
	

	@Test
	void mapToUserWithUserAndUserParamTest() {
		
		User 	u 				= UserMapper.mapToUser(user, userParam);
		boolean isFirstNameSame = u.getFirstName().equals(userParam.getFirstName());
		assertTrue(isFirstNameSame);
	}
	
	@Test
	void mapToUserDTOTest() {
		
		UserDTO userDTO 		= UserMapper.mapToUserDTO(user);
		boolean isUserIdSame 	= user.getUserId().equals(userDTO.getUserId());
		assertTrue(isUserIdSame);
	}
	
	@Test
	void mapToUserDTOListTest() {
		
		List<User> users = Arrays.asList(user);
		
																	// Check User list converted to UserDTO
		List<UserDTO> 	usersDTO 			= UserMapper.mapToUserDTOList(users);
		boolean 		hasOnlyDTOInstances = usersDTO.stream().allMatch(userDTO -> userDTO instanceof UserDTO);
		assertTrue(hasOnlyDTOInstances);
		
																	// check size of both list
		boolean hasSameSize = users.size() == usersDTO.size();
		assertTrue(hasSameSize);
	}
	
}