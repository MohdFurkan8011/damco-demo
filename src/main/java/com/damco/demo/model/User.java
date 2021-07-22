package com.damco.demo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "user")
public class User {

	@Id
	private String userId;
	
	@Field(name = "sur_name")
	private String surName;
	
	@Field(name = "first_name")
	private String firstName;
	
	@Field(name = "title")
	private String title;
	
	@Field(name = "dob")
	private LocalDate dob;
	
}