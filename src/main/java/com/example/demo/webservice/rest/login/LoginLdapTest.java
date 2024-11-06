package com.example.demo.webservice.rest.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginLdapTest {
	
	@GetMapping("/")
	public String index() {
		
		return "Home page";
	}

}
