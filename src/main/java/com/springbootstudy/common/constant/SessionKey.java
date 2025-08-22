package com.springbootstudy.common.constant;

public enum SessionKey {

	LOGIN_INFO("SESSION_LOGIN_INFO");

	private String key;

	private SessionKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
