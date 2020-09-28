package com.spring.rentcar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.rentcar.commons.Criteria;
import com.spring.rentcar.domain.ReplyVO;
import com.spring.rentcar.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ReplyDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Inject
	private ReplyDAO dao;
	
	/*
	@Ignore
	public void createTest() throws Exception{
		
		ReplyVO vo = new ReplyVO();
		
		
		for(int i = 0; i < 100; i++) {
			
			vo.setBno(19);
			vo.setReplyer("user"+i);
			vo.setReplyText("글 작성"+i);
		
			dao.create(vo);
		}
	}
	*/

	/*
	@Ignore
	public void listTest() throws Exception{
		
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		
		list = dao.list(19);
		
		for (ReplyVO replyVO : list) {
			
			
			logger.info(replyVO.getRno()+":"+replyVO.getReplyText());
		}
	}
	
	@Ignore
	public void updateTest() throws Exception{
		
		ReplyVO vo = new ReplyVO();
		
		vo.setRno(11);
		vo.setReplyText("글 수정");
		
		dao.update(vo);
		
	}
	
	@Test
	public void deleteTest() throws Exception{
		
		dao.delete(11);
		
		
	}
	*/
	
	@Test
	public void listPagingTest() throws Exception{
		
		Criteria cri = new Criteria();
		
		cri.setPerPageNum(10);
		cri.setPage(1);
		
		dao.listPaging(19, cri);
		
	}
	
	
	
	
	
}
