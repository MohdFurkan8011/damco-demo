package com.damco.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.damco.demo.dto.UserDTO;
import com.damco.demo.model.User;
import com.damco.demo.params.UserParam;

public class UserMapper {

	private static final  ModelMapper modelMapper;
	
	private UserMapper() {}
	
	static {
		modelMapper = new ModelMapper();
	}
	
	public static User mapToUser(UserParam userParam) {
		
		
		return mapping(new User(), userParam);
	}
	
	public static User mapToUser(User user, UserParam userParam) {
		
		return mapping(user, userParam);
	}
	
	private static User mapping(User user, UserParam userParam) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userParam, user);
		
		return user;
	}
	
	public static UserDTO mapToUserDTO(User user) {
		
		return modelMapper.map(user, UserDTO.class);
	}
	
	public static List<UserDTO> mapToUserDTOList(List<User> users) {
		
		return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
	}
	
}
