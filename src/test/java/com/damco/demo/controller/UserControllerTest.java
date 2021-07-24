package com.damco.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.management.MalformedObjectNameException;

import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.damco.demo.model.User;
import com.damco.demo.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {
	
	private final String 	URL					= "http://localhost:8080/user";

	private final String 	EXPECTED_USER_ID 	= "60f96420c6f7bb1290c6ec26";
	private final String 	EXPECTED_SUR_NAME 	= "Mr.";
	private final String 	EXPECTED_FIRST_NAME = "ABC";
	private final String 	EXPECTED_TITLE 		= "Java Developer";
	private final LocalDate EXPECTED_DOB 		= LocalDate.now();
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	void findAllTest() throws Exception {
		
		List<User> users = Arrays.asList(new User(EXPECTED_USER_ID, EXPECTED_SUR_NAME, EXPECTED_FIRST_NAME, EXPECTED_TITLE, EXPECTED_DOB));
		
		Mockito.when(userService.findAll()).thenReturn(users);

		mockMvc.perform(MockMvcRequestBuilders.get(URL)
	               .contentType(APPLICATION_JSON))
	         	.andExpect(status().isOk())
	         	.andExpect(jsonPath("$", IsCollectionWithSize.hasSize(users.size())))
	         	.andExpect(jsonPath("$[0].userId", Is.is(EXPECTED_USER_ID)));
	}
	
	@Test
	void saveTest() throws Exception {
		
		User 	user 		= getUser();
		String 	jsonObject 	= getJsonObjectString();
		
		Mockito.when(userService.saveOrUpdate(Mockito.any())).thenReturn(user);
		
		mockMvc.perform(MockMvcRequestBuilders.post(URL)
	               .contentType(APPLICATION_JSON)
	               .content(jsonObject))
	         	.andExpect(status().isCreated())
	         	.andExpect(jsonPath("$.userId").value(user.getUserId()));
	}
	
	@Test
	void updateTest() throws Exception {
		
		User 	user 		= getUser();
		user.setFirstName("Updatedname");
		
		String 	jsonObject 	= getJsonObjectString();
		
		Optional<User> userOpt = Optional.of(user);
		Mockito.when(userService.findByUserId(EXPECTED_USER_ID)).thenReturn(userOpt);
		Mockito.when(userService.saveOrUpdate(Mockito.any())).thenReturn(user);
		
		mockMvc.perform(MockMvcRequestBuilders.put(URL+"/"+EXPECTED_USER_ID)
	               .contentType(APPLICATION_JSON)
	               .content(jsonObject))
	         	.andExpect(status().isOk())
	         	.andExpect(jsonPath("$.firstName").value(user.getFirstName()));
	}
	
	@Test
	void deleteByIdTest() throws Exception {
		
		// When user exists by id
		Mockito.when(userService.existsById(EXPECTED_USER_ID)).thenReturn(true);
		
		mockMvc.perform(MockMvcRequestBuilders.delete(URL+"/"+EXPECTED_USER_ID)
	               .contentType(APPLICATION_JSON))
	         	.andExpect(status().isOk())
	         	.andExpect(jsonPath("$.message").value("User is successfully deleted."));
		
		// When user does not exist by id
		Mockito.when(userService.existsById(EXPECTED_USER_ID)).thenReturn(false);
				
		mockMvc.perform(MockMvcRequestBuilders.delete(URL+"/"+EXPECTED_USER_ID)
		           .contentType(APPLICATION_JSON))
		       	.andExpect(status().isOk())
		       	.andExpect(jsonPath("$.message").value("User does not exist for userId :"+EXPECTED_USER_ID));
	}
	
	private User getUser() {
		
		return new User(EXPECTED_USER_ID, EXPECTED_SUR_NAME, EXPECTED_FIRST_NAME, EXPECTED_TITLE, EXPECTED_DOB);
	}
	
	public String getJsonObjectString() throws Exception {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("surName", EXPECTED_SUR_NAME);
		jsonObject.put("firstName", EXPECTED_FIRST_NAME);
		jsonObject.put("title", EXPECTED_TITLE);
		jsonObject.put("dob", "2021-01-01");

		return jsonObject.toString();
	}

}
