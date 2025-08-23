package com.springbootstudy.web.top;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * トップページのコントローラー
 */
@Controller
@RequestMapping("/top")
public class TopController {
	private static final Logger logger = LoggerFactory.getLogger(TopController.class);

	/**
	 * トップ画面を表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("")
	public String show(Model model) {
		logger.debug("start");

		return "top/top";
	}
}
