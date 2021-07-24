package com.damco.demo.dto;

import java.time.LocalDate;

import com.damco.demo.params.UserParam;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO extends UserParam {

	private String userId;
	
	public UserDTO(String userId, String surName, String firstName, String title, LocalDate dob) {
		super(surName, firstName, title, dob);
		this.userId = userId;
	}
	
}
