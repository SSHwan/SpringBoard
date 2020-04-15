package com.seunghwan.springBoard.user.service;

import com.seunghwan.springBoard.user.dao.UserDao;
import com.seunghwan.springBoard.user.dto.LoginDto;
import com.seunghwan.springBoard.user.dto.UserDto;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	private final UserDao userDao;

	@Inject
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public void joinUser(UserDto userDto) throws Exception {
		this.userDao.joinUser(userDto);
		this.userDao.joinUserAuthority(userDto);
	}

	@Override
	public UserDto login(LoginDto loginDto) throws Exception {
		return this.userDao.selectUser(loginDto);
	}

	@Override
	public void updateLoginDate(UserDto userDto) throws Exception {
		this.userDao.updateLoginDate(userDto);
	}

	@Override
	public int userIdCheck(String user_id) throws Exception {
		return this.userDao.userIdCheck(user_id);
	}
}