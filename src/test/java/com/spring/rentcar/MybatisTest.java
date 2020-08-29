package com.spring.rentcar;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MybatisTest {
	
	@Inject
	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testFactory() throws Exception{

		logger.info("sqlSessionFactory:"+sqlSessionFactory);
	}
	
	@Test
	public void testSession() throws Exception{
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			logger.info("session:"+session);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
