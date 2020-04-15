package com.seunghwan.springBoard.user.dao;

import com.seunghwan.springBoard.user.dto.LoginDto;
import com.seunghwan.springBoard.user.dto.UserDto;

public interface UserDao {
	void joinUser(UserDto var1) throws Exception;

	void joinUserAuthority(UserDto var1) throws Exception;

	UserDto selectUser(LoginDto var1) throws Exception;

	void updateLoginDate(UserDto var1) throws Exception;

	int userIdCheck(String var1) throws Exception;
}