package com.example.springsecuritytest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
public class TestControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void givenNoCredentials_shouldAccessPublicEndpoint() throws Exception {
		mvc.perform(get("/public"))
				.andExpect(status().isOk());
	}

	@Test
	public void givenNoCredentials_shouldNotAccessSecuredEndpoint() throws Exception {
		mvc.perform(get("/private"))
				.andExpect(status().isUnauthorized());
	}

	@Test
	@WithMockUser
	public void givenMockedCredentials_shouldAccessSecuredEndpoint() throws Exception {
		mvc.perform(get("/private"))
				.andExpect(status().isOk());
	}

}