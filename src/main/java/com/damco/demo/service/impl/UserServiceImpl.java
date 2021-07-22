package com.damco.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damco.demo.model.User;
import com.damco.demo.repository.UserRepository;
import com.damco.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * @param userId
	 * @return boolean
	 * return true if user exists by userId otherwise false
	 */
	@Override
	public boolean existsById(String userId) {
		
		return userRepository.existsById(userId);
	}
	
	/**
	 * 
	 * @param userId
	 * @return Optional<User>
	 * return optional for User by userId
	 */
	@Override
	public Optional<User> findByUserId(String userId) {
		
		return userRepository.findById(userId);
	}
	
	/**
	 * 
	 * @return List<User>
	 * returns list of users
	 */
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * saves if user's id is null otherwise update user
	 */
	@Override
	public User saveOrUpdate(User user) {
		
		return userRepository.save(user);
	}
	
	/**
	 * 
	 * @param userId
	 * deletes user by id
	 */
	@Override
	public void deleteById(String userId) {
		
		userRepository.deleteById(userId);
	}
	
	
}