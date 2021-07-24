package com.damco.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damco.demo.dto.UserDTO;
import com.damco.demo.mapper.UserMapper;
import com.damco.demo.model.User;
import com.damco.demo.params.UserParam;
import com.damco.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	@ApiOperation(value = "View a list of available users")
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> users 		= 	userService.findAll();
		
														// converts users list to usersDTO list
		List<UserDTO> usersDTO 	=	UserMapper.mapToUserDTOList(users);
		
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Saves user")
	public ResponseEntity<UserDTO> save(@RequestBody @Valid UserParam userParam) {
		
														// converts userParam to User model then saves and returns
		User 	user 		= 	userService.saveOrUpdate(UserMapper.mapToUser(userParam));
		
														// converts user model to userDTO
		UserDTO userDto		=	UserMapper.mapToUserDTO(user);
		
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{userId}")
	@ApiOperation(value = "Updates user")
	public ResponseEntity<UserDTO> update(
			@PathVariable(value = "userId") String 		userId,
			@RequestBody 	@Valid			UserParam 	userParam) {
		
														// finds user by id if presents, it updates otherwise no
		Optional<User> userOpt = userService.findByUserId(userId);
		userOpt.ifPresent(user -> userService.saveOrUpdate(UserMapper.mapToUser(user, userParam)));
		
														// converts user model to userDTO
		UserDTO userDto = UserMapper.mapToUserDTO(userOpt.orElse(new User()));
		
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{userId}")
	@ApiOperation(value = "Deletes user")
	public ResponseEntity<Map<String, String>> deleteById(@PathVariable("userId") String userId) {
		
		boolean 			isExists = userService.existsById(userId);
		Map<String, String> result = new HashMap<>();
		
		if (isExists) {
			
			userService.deleteById(userId);
			result.put("message", "User is successfully deleted.");
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		else {
			result.put("message", "User does not exist for userId :"+userId);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
			
	}
	
}