package com.springbootstudy.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.springbootstudy.common.bean.LoginInfo;
import com.springbootstudy.common.constant.SessionKey;
import com.springbootstudy.common.exception.IllegalUserAccessException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ログインユーザーにリクエストページへアクセスする権限があるかチェックするInterceptor
 */
public class AccessCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LoginInfo info = (LoginInfo) request.getSession().getAttribute(SessionKey.LOGIN_INFO.getKey());
		if (info == null) {
			throw new IllegalUserAccessException();
		}
		return true;
	}
}
