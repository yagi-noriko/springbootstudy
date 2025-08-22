package com.springbootstudy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootstudy.web.login.LoginController;

@SpringBootTest
public class BootApplicationTests {

	private LoginController loginController;

	@Autowired
	public BootApplicationTests(LoginController loginController) {
		super();
		this.loginController = loginController;
	}

	@Test
	void contextLoads() {
		assertThat(loginController).isNotNull();
	}
}
