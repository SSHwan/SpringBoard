package com.seunghwan.springBoard.user.service;

import com.seunghwan.springBoard.user.dto.LoginDto;
import com.seunghwan.springBoard.user.dto.UserDto;

public interface UserService {
	void joinUser(UserDto var1) throws Exception;

	UserDto login(LoginDto var1) throws Exception;

	void updateLoginDate(UserDto var1) throws Exception;

	int userIdCheck(String var1) throws Exception;
}