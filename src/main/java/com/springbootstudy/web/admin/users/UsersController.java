package com.springbootstudy.web.admin.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootstudy.web.admin.AdminController;

import jakarta.servlet.http.HttpSession;

/**
 * ユーザー管理画面のコントローラー
 */
@Controller
@RequestMapping("/users")
public class UsersController extends AdminController {

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	private HttpSession session;

	private final UsersService service;

	@Autowired
	public UsersController(HttpSession session, UsersService service) {
		this.session = session;
		this.service = service;
	}

	/**
	 * ユーザー一覧表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("")
	public String show(Model model) {
		logger.debug("start");

		model.addAttribute("users", service.getAllActiveUsers());
		return getViewPath("users");
	}

	private String getViewPath(String path) {
		return super.getAdminViewPath(path);
	}

}
