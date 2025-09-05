package com.springbootstudy.web.admin.users;

import org.hibernate.validator.constraints.Length;

import com.springbootstudy.repository.user.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * ユーザ登録更新フォーム
 */
public class UserForm {

	private String userId;

	@NotBlank
	@Pattern(regexp = "^[\\p{Alnum}|\\p{Punct}]*$", message = "{common.validation.Pattern.message.ascii}")
	private String loginId;

	@Pattern(regexp = "^[\\p{Alnum}|\\p{Punct}]*$", message = "{common.validation.Pattern.message.ascii}")
	private String password;

	@Length(max = 300)
	private String firstName;

	@Length(max = 300)
	private String lastName;

	public UserForm() {
	}

	public UserForm(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.loginId = user.getLoginId();
		this.password = user.getPassword();
		this.userId = user.getUserId().toString();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
