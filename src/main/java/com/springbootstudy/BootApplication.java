package com.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBootのアプリケーションを起動するクラス
 */
@Configuration
@SpringBootApplication
public class BootApplication {

	/**
	 * アプリケーションを起動する
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
