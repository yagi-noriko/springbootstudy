package com.springbootstudy.web.admin.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootstudy.repository.user.User;
import com.springbootstudy.repository.user.UserRepository;

/**
 * ユーザー管理画面のサービスクラス
 */
@Service
public class UsersService {

	private final UserRepository userRepository;

	public UsersService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * アクティブユーザーをすべて取得
	 * 
	 * @return
	 */
	public List<User> getAllActiveUsers() {
		return userRepository.findAll().stream().filter(u -> !u.isDeleted()).collect(Collectors.toList());
	}

}
