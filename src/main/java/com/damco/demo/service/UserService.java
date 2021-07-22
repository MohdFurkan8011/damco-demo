package com.damco.demo.service;

import java.util.List;
import java.util.Optional;

import com.damco.demo.model.User;

public interface UserService {
	
	/**
	 * 
	 * @param userId
	 * @return boolean
	 * return true if user exists by userId otherwise false
	 */
	public boolean existsById(String userId);

	/**
	 * 
	 * @param userId
	 * @return Optional<User>
	 * return optional for User by userId
	 */
	public Optional<User> findByUserId(String userId);
	
	/**
	 * 
	 * @return List<User>
	 * returns list of users
	 */
	public List<User> findAll();
	
	/**
	 * 
	 * @param user
	 * @return
	 * saves if user's id is null otherwise update user
	 */
	public User saveOrUpdate(User user);
	
	/**
	 * 
	 * @param userId
	 * deletes user by id
	 */
	public void deleteById(String userId);
	
}