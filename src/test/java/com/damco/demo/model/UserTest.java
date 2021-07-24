package com.damco.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	public static final String 		EXPECTED_USER_ID 		= 	"60f96420c6f7bb1290c6ec26";
	public static final String 		EXPECTED_SUR_NAME 		= 	"Mr.";
	public static final String 		EXPECTED_FIRST_NAME 	= 	"ABC";
	public static final String 		EXPECTED_TITLE 			= 	"Java Developer";
	public static final LocalDate 	EXPECTED_DOB 			= 	LocalDate.now();
	
	private User underTest;
	
	@BeforeEach
	public void init() {
		
		underTest = new User(EXPECTED_USER_ID, EXPECTED_SUR_NAME, EXPECTED_FIRST_NAME, EXPECTED_TITLE, EXPECTED_DOB);
	}
	
	@Test
	void userParamTest() {
		
		assertEquals(EXPECTED_SUR_NAME, 	underTest.getSurName());
		assertEquals(EXPECTED_FIRST_NAME, 	underTest.getFirstName());
		assertEquals(EXPECTED_TITLE, 		underTest.getTitle());
		assertEquals(EXPECTED_DOB, 			underTest.getDob());
	}

}
