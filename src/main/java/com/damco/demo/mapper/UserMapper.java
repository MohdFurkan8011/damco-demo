package com.damco.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.damco.demo.dto.UserDTO;
import com.damco.demo.model.User;
import com.damco.demo.params.UserParam;

/**
 * 
 * @author Mohd Furkan
 */
public class UserMapper {

	private static final  ModelMapper modelMapper;
	
	private UserMapper() {}
	
	static {
		modelMapper = new ModelMapper();
	}
	
	/**
	 * 
	 * @param userParam
	 * @return User
	 * creates new instance of User and copies values from userParam to User
	 */
	public static User mapToUser(UserParam userParam) {
		
		
		return mapping(new User(), userParam);
	}
	
	/**
	 * 
	 * @param user
	 * @param userParam
	 * @return User
	 * copies all values from UserParam to User
	 */
	public static User mapToUser(User user, UserParam userParam) {
		
		return mapping(user, userParam);
	}
	
	/**
	 * 
	 * @param user
	 * @param userParam
	 * @return User
	 * copies all values from UserParam to User
	 */
	private static User mapping(User user, UserParam userParam) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userParam, user);
		
		return user;
	}
	
	/**
	 * 
	 * @param user
	 * @return UserDTO
	 * converts User to UserDTO
	 */
	public static UserDTO mapToUserDTO(User user) {
		
		return modelMapper.map(user, UserDTO.class);
	}
	
	/**
	 * 
	 * @param users
	 * @return List<UserDTO>
	 * converts List<User> to List<UserDTO>
	 */
	public static List<UserDTO> mapToUserDTOList(List<User> users) {
		
		return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
	}
	
}
