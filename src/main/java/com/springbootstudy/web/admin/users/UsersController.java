package com.springbootstudy.web.admin.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootstudy.web.admin.AdminController;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpSession;

/**
 * ユーザー管理画面のコントローラー
 */
@Controller
@RequestMapping("admin/users")
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

		model.addAttribute("users", service.findAllActiveUsers());
		return getViewPath("users");
	}

	/**
	 * ユーザー編集表示
	 * 
	 * @param model
	 * @param userId
	 * @return
	 */
	@GetMapping("edit")
	public String edit(Model model, @RequestParam(name = "userId", required = false) String userId) {
		logger.debug("edit : " + userId);
		UserForm form = new UserForm();
		if (StringUtils.isNotBlank(userId)) {
			form = service.findUserById(userId);

		}
		model.addAttribute("userForm", form);

		return getViewPath("edit");
	}

	@PostMapping("edit")
	public String update(Model model, @ModelAttribute @Validated UserForm form) throws Exception {
		logger.debug("update : " + form.getUserId());

		form = service.addOrUpdateUser(form);

		return "redirect:/admin/users";
	}

	private String getViewPath(String path) {
		return super.getAdminViewPath("users/") + path;
	}

}
