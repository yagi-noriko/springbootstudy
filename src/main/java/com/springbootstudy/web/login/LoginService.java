package com.springbootstudy.web.login;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootstudy.repository.user.User;
import com.springbootstudy.repository.user.UserRepository;

@Service
public class LoginService {

	private final UserRepository userRepository;

	public LoginService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * ログインIDとパスワードから一致するユーザーを検索する。
	 * 
	 * @param loginId
	 * @return
	 */
	public User findUserByLoginId(String loginId) {
		List<User> result = userRepository.findAll()
				.stream()
				.filter(e -> e.getLoginId().equals(loginId))
				.collect(Collectors.toList());
		if (result.size() == 1) {
			return result.get(0);
		}
		return null;
	}
}
