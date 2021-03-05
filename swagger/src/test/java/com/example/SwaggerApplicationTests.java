package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SwaggerApplicationTests {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		//$2a$10$pu8n57O5qIY06hlX4RfwMODQ.AkQYSkdod6ZlFJEAv3iR7pDXanwi
		//$2a$10$yafGc09R2tg.PTd5tAF95emqvkVbrt2JuSoPLsptZGmB3ZJv7msye
//		System.out.println(passwordEncoder.encode("dj666"));
		System.out.println(passwordEncoder.matches("dj666","$2a$10$pu8n57O5qIY06hlX4RfwMODQ.AkQYSkdod6ZlFJEAv3iR7pDXanwi"));
	}

}
