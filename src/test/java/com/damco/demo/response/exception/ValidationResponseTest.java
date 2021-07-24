package com.damco.demo.response.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidationResponseTest {

	private final Integer 	ERROR_CODE				=	400;
	private final String	ERROR_MESSAGE			=	"Validation error.";
	private final String 	FIELD 					= 	"firstName";
	private final String 	FIELD_MESSAGE 			= 	"First name can not blnak";
	
	private ValidationResponse underTest;
	
	@BeforeEach
	void init() {
		
		 underTest = new ValidationResponse(ERROR_CODE, ERROR_MESSAGE);
	}
	

	@Test
	void addValidationErrorTest() {
		
		underTest.addValidationError(FIELD, FIELD_MESSAGE);
		
		assertEquals(ERROR_CODE, 	underTest.getStatus());
		assertEquals(ERROR_MESSAGE, underTest.getMessage());
		assertEquals(FIELD, 		underTest.getErrors().get(0).getField());
		assertEquals(FIELD_MESSAGE, underTest.getErrors().get(0).getMessage());
	}

}
