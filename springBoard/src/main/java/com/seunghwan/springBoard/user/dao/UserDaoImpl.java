package com.seunghwan.springBoard.user.dao;

import com.seunghwan.springBoard.user.dto.LoginDto;
import com.seunghwan.springBoard.user.dto.UserDto;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	private static final String NAMESPACE = "com.seunghwan.springBoard.mappers.user.userMapper";
	private final SqlSession sqlSession;

	@Inject
	public UserDaoImpl(SqlSession sqlSession) throws Exception {
		this.sqlSession = sqlSession;
	}

	@Override
	public void joinUser(UserDto userDto) throws Exception {
		this.sqlSession.insert("com.seunghwan.springBoard.mappers.user.userMapper.joinUser", userDto);
	}

	@Override
	public void joinUserAuthority(UserDto userDto) throws Exception {
		this.sqlSession.insert("com.seunghwan.springBoard.mappers.user.userMapper.joinUserAuthority", userDto);
	}

	@Override
	public UserDto selectUser(LoginDto loginDto) throws Exception {
		return (UserDto) this.sqlSession.selectOne("com.seunghwan.springBoard.mappers.user.userMapper.selectUser",
				loginDto);
	}

	@Override
	public void updateLoginDate(UserDto userDto) throws Exception {
		this.sqlSession.update("com.seunghwan.springBoard.mappers.user.userMapper.updateLoginDate", userDto);
	}

	@Override
	public int userIdCheck(String user_id) throws Exception {
		return (Integer) this.sqlSession.selectOne("com.seunghwan.springBoard.mappers.user.userMapper.userIdCheck",
				user_id);
	}
}