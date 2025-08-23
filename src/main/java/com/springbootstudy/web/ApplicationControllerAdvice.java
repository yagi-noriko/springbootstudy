package com.springbootstudy.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbootstudy.common.exception.IllegalUserAccessException;

/**
 * アプリケーション全体のExceptionを処理するクラス
 */
@ControllerAdvice
public class ApplicationControllerAdvice {

	private MessageSource messageSource;

	@Autowired
	public ApplicationControllerAdvice(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	/**
	 * 不正アクセスのエラーメッセージを表示する
	 * 
	 * @param e
	 * @param handler
	 * @param locale
	 * @return
	 */
	@ExceptionHandler(IllegalUserAccessException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ModelAndView illegalAccess(Exception e, HandlerMethod handler, Locale locale) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message", messageSource.getMessage("message.exception.illegal-access", new String[] {}, locale));
		return mv;
	}

	/**
	 * 個別のエラーメッセージを表示しない場合、すべてこのメソッドで「システムエラー」として表示される。
	 * 
	 * @param e
	 * @param handler
	 * @param locale
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView serverError(Exception e, HandlerMethod handler, Locale locale) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message", messageSource.getMessage("message.exception.server-error", new String[] {}, locale));
		return mv;
	}
}
