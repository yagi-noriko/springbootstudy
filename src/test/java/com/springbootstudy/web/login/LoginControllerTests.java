package com.springbootstudy.web.login;

import java.nio.charset.StandardCharsets;

import org.assertj.core.api.StringAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResultAssert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTests {

	MockMvcTester mvc;

	@Autowired
	public LoginControllerTests(MockMvcTester mvc) {
		super();
		this.mvc = mvc;
	}

	@Test
	void testShow() {
		MvcTestResultAssert result = mvc.get().uri("/login").exchange().assertThat();
		result.hasStatusOk();
		result.hasContentType(new MediaType(MediaType.TEXT_HTML, StandardCharsets.UTF_8));

		StringAssert body = (StringAssert) result.bodyText();
		body.contains("input", "type=\"text\"", "name=\"loginId\"");
		body.contains("input", "type=\"password\"", "name=\"password\"");

	}

	@Test
	void testLogin() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		MvcTestResultAssert result = mvc.post().uri("/login").params(params).exchange().assertThat();
		result.hasStatus3xxRedirection();
		result.hasRedirectedUrl("/top");
	}
}
