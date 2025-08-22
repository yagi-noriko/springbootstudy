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

@ControllerAdvice
public class ApplicationControllerAdvice {

	private MessageSource messageSource;

	@Autowired
	public ApplicationControllerAdvice(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@ExceptionHandler(IllegalUserAccessException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ModelAndView illegalAccess(Exception e, HandlerMethod handler, Locale locale) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message", messageSource.getMessage("message.exception.illegal-access", new String[] {}, locale));
		return mv;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView serverError(Exception e, HandlerMethod handler, Locale locale) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message", messageSource.getMessage("message.exception.server-error", new String[] {}, locale));
		return mv;
	}
}
