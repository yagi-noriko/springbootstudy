package com.springbootstudy.common.bean;

/**
 * ログインユーザーの情報をセッションに保持するためのBean
 */
public class LoginInfo {

	private String userId;

	/**
	 * ユーザーIDを取得する
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDを設定する
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
