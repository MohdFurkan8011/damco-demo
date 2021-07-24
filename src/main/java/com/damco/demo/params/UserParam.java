package com.damco.demo.params;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserParam {

	@NotBlank(message = "Sur name can not be null/blank.")
	private String surName;
	
	@NotBlank(message = "First name can not be null/blank.")
	private String firstName;
	
	@NotBlank(message = "Title can not be null/blank.")
	private String title;
	
	@NotNull(message = "DOB can not be null")
	private LocalDate dob;
	
}