package com.springbootstudy.common.constant;

/**
 * セッションキーのEnum
 */
public enum SessionKey {

	LOGIN_INFO("SESSION_LOGIN_INFO");

	private String key;

	private SessionKey(String key) {
		this.key = key;
	}

	/**
	 * セッションキーの文字列を取得する
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}
}
