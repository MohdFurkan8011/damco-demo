package com.damco.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.damco.demo.model.User;
import com.damco.demo.repository.UserRepository;

class UserServiceImplTest {

	private User userDummy;
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl 	underTest;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void init() {
		
		MockitoAnnotations.initMocks(this);
		userDummy		=	new User("60f96420c6f7bb1290c6ec26", "Mr.", "ABC", "Java Developer", LocalDate.now());
	}
	
	@Test
	void existsByIdTest() {
		
		Mockito.when(userRepository.existsById(userDummy.getUserId())).thenReturn(true);
		
		boolean isUserExists = underTest.existsById(userDummy.getUserId());
		Assert.assertTrue(isUserExists);
	}
	
	@Test
	void findByUserIdTest() {
		
		Optional<User> userDummyOpt = Optional.of(userDummy);
		Mockito.when(userRepository.findById(userDummy.getUserId())).thenReturn(userDummyOpt);
		
		Optional<User> userOpt = underTest.findByUserId(userDummy.getUserId());
		userOpt.ifPresent(userDB -> {
			assertEquals(userDB.getUserId(), 	userDummy.getUserId());
			assertEquals(userDB.getSurName(), 	userDummy.getSurName());
			assertEquals(userDB.getFirstName(), userDummy.getFirstName());
			assertEquals(userDB.getTitle(), 	userDummy.getTitle());
			assertEquals(userDB.getDob(), 		userDummy.getDob());
		});
	}
	
	@Test
	void findAllTest() {
		
		List<User> users = Arrays.asList(userDummy);
		Mockito.when(userRepository.findAll()).thenReturn(users);
		
		List<User> 	usersFromDB = underTest.findAll();
		User 		userDB 		= usersFromDB.get(0);
		
		assertEquals(userDB.getUserId(), 	userDummy.getUserId());
		assertEquals(userDB.getSurName(), 	userDummy.getSurName());
		assertEquals(userDB.getFirstName(), userDummy.getFirstName());
		assertEquals(userDB.getTitle(), 	userDummy.getTitle());
		assertEquals(userDB.getDob(), 		userDummy.getDob());
	}
	
	@Test
	void saveOrUpdateTest() {
		
		Mockito.when(userRepository.save(userDummy)).thenReturn(userDummy);
		User userDB = underTest.saveOrUpdate(userDummy);
		
		assertEquals(userDB.getUserId(),	userDummy.getUserId());
		assertEquals(userDB.getSurName(), 	userDummy.getSurName());
		assertEquals(userDB.getFirstName(), userDummy.getFirstName());
		assertEquals(userDB.getTitle(), 	userDummy.getTitle());
		assertEquals(userDB.getDob(), 		userDummy.getDob());
	}
	
	@Test
	void deleteByIdTest() {
		
		underTest.deleteById(userDummy.getUserId());
		Mockito.verify(userRepository, Mockito.times(1)).deleteById(userDummy.getUserId());
	}

}