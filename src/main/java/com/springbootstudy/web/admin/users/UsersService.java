package com.springbootstudy.web.admin.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootstudy.common.exception.InvalidDataException;
import com.springbootstudy.repository.user.User;
import com.springbootstudy.repository.user.UserRepository;

import io.micrometer.common.util.StringUtils;

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
	public List<UserForm> findAllActiveUsers() {
		return userRepository.findAll()
				.stream()
				.filter(u -> !u.isDeleted())
				.map(u -> new UserForm(u))
				.collect(Collectors.toList());
	}

	/**
	 * userIdからユーザーを取得
	 * 
	 * @return
	 */
	public UserForm findUserById(String userId) {
		User user = userRepository.findById(Long.valueOf(userId)).orElse(null);
		if (user == null) {
			return null;
		}
		return new UserForm(user);
	}

	/**
	 * ユーザーを登録更新する
	 * 
	 * @param form
	 * @return
	 * @throws InvalidDataException
	 */
	public UserForm addOrUpdateUser(UserForm form) throws InvalidDataException {
		User user = new User();
		if (StringUtils.isNotBlank(form.getUserId())) {
			user = userRepository.findById(Long.valueOf(form.getUserId()))
					.orElseThrow(() -> new InvalidDataException("Not Found : userId = " + form.getUserId()));
		}
		user.setLoginId(form.getLoginId());
		if (StringUtils.isNotBlank(form.getPassword())) {
			user.setPassword(form.getPassword());
		}
		user.setLastName(form.getLastName());
		user.setFirstName(form.getFirstName());
		return new UserForm(userRepository.save(user));
	}
}
