package com.example.springsecuritytest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/public")
	private String publicEndpoint() {
		return "public";
	}

	@GetMapping("/private")
	private String privateEndpoint() {
		return "private";
	}
}
