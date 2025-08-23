package com.springbootstudy;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springbootstudy.common.interceptor.AccessCheckInterceptor;

/**
 * SpringMVC用のJavaConfigurationクラス
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * インターセプタ―を設定する。
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AccessCheckInterceptor()).excludePathPatterns("/", "/index", "/index.*", "/login");
	}
}
