package com.springbootstudy.web.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 管理画面共通のコントローラー
 */
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	public AdminController() {
	}

	protected String getAdminViewPath(String path) {
		return "admin/" + path;
	}
}
