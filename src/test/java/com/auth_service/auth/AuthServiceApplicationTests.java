package com.auth_service.auth;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;



@SpringBootTest
@ActiveProfiles("test")
@Import(TestSecurityConfig.class)
class AuthServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
