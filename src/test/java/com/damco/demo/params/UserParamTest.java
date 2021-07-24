package com.damco.demo.params;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserParamTest {

	public static final String 		EXPECTED_SUR_NAME 		= 	"Mr.";
	public static final String 		EXPECTED_FIRST_NAME 	= 	"ABC";
	public static final String 		EXPECTED_TITLE 			= 	"Java Developer";
	public static final LocalDate 	EXPECTED_DOB 			= 	LocalDate.now();
	
	private UserParam underTest;
	
	@BeforeEach
	public void init() {
		
		underTest = new UserParam(EXPECTED_SUR_NAME, EXPECTED_FIRST_NAME, EXPECTED_TITLE, EXPECTED_DOB);
	}
	
	@Test
	void userParamTest() {
		
		assertEquals(EXPECTED_SUR_NAME, 	underTest.getSurName());
		assertEquals(EXPECTED_FIRST_NAME, 	underTest.getFirstName());
		assertEquals(EXPECTED_TITLE, 		underTest.getTitle());
		assertEquals(EXPECTED_DOB, 			underTest.getDob());
	}

}
