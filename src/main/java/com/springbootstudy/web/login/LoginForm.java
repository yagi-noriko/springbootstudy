package com.springbootstudy.web.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class LoginForm {

	@NotBlank
	@Pattern(regexp = "^[\\p{Alnum}|\\p{Punct}]*$", message = "{common.validation.Pattern.message.ascii}")
	private String loginId;

	@NotBlank
	@Pattern(regexp = "^[\\p{Alnum}|\\p{Punct}]*$", message = "{common.validation.Pattern.message.ascii}")
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
