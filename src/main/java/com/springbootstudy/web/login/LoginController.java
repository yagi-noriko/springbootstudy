package com.springbootstudy.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootstudy.common.bean.LoginInfo;
import com.springbootstudy.common.constant.SessionKey;
import com.springbootstudy.repository.user.User;

import jakarta.servlet.http.HttpSession;

/**
 * ログイン画面のコントローラー
 */
@Controller
@RequestMapping("login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private HttpSession session;

	private final LoginService service;

	@Autowired
	public LoginController(HttpSession session, LoginService service) {
		this.session = session;
		this.service = service;
	}

	/**
	 * ログインページ表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("")
	public String show(Model model) {
		logger.debug("start");

		model.addAttribute("loginForm", new LoginForm());

		return "login/login";
	}

	/**
	 * ログイン実行
	 * 
	 * @param model
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("")
	public String login(Model model, @ModelAttribute @Validated LoginForm form, BindingResult bindingResult) {
		logger.debug("start");

		// 入力エラー
		if (bindingResult.hasErrors()) {
			return "login/login";
		}

		User user = service.findUserByLoginId(form.getLoginId());
		if (user == null) {
			bindingResult.rejectValue("loginId", "message.login.invalid.login-id.notfound", "not found");
			return "login/login";
		}
		if (!user.getPassword().equals(form.getPassword())) {
			bindingResult.rejectValue("password", "message.login.invalid.password.notequal", "invalid password");
			return "login/login";
		}

		LoginInfo info = new LoginInfo();
		info.setUserId(form.getLoginId());

		this.session.setAttribute(SessionKey.LOGIN_INFO.getKey(), info);

		return "redirect:/top";
	}

}
