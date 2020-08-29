package com.spring.rentcar.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.rentcar.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	
	@Inject
	private SqlSession session;
	
	@Inject
	private static final String namespace = "com.spring.rentcar.userMapper";
	
	@Override
	public String getTime() {
		
		return session.selectOne(namespace+".getTime");
	}

	@Override
	public void insertUser(UserVO userVO) {

		session.insert(namespace+".insertUser", userVO);
	}

	@Override
	public UserVO readUser(String userId) throws Exception {

		return session.selectOne(namespace+".readUser", userId);
	}

	@Override
	public UserVO readWithPw(String userId, String userPw) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		
		return session.selectOne(namespace+".readWithPw", map);
	}

}
