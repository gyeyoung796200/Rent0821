package com.spring.rentcar.persistence;

import com.spring.rentcar.domain.UserVO;

public interface UserDAO {

	//현재 시간가져옴
	public String getTime();
	
	//사용자 추가(회원가입)
	public void insertUser(UserVO userVO);
	
	//유저 정보읽기
	public UserVO readUser(String userId) throws Exception;
	
	//아이디랑 비밀번호 읽기
	public UserVO readWithPw(String userId, String userPw) throws Exception;
}
