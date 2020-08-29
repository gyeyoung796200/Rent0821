package com.spring.rentcar;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.rentcar.domain.UserVO;
import com.spring.rentcar.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDAOTest {
	
	
	@Inject
	private UserDAO dao;
	
	@Ignore
	public void getTime() throws Exception{
		
		System.out.println(dao.getTime());
	}
	
	@Test
	public void insertUser() throws Exception{
		
		UserVO userVO = new UserVO();
		
		userVO.setUserId("user2");
		userVO.setUserPw("1234");
		userVO.setUserName("사용자2");
		userVO.setUserEmail("user2@test.com");
		
		dao.insertUser(userVO);
	}

}
