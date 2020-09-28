package com.spring.rentcar;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.rentcar.commons.Criteria;
import com.spring.rentcar.commons.PageMaker;
import com.spring.rentcar.commons.SearchCriteria;
import com.spring.rentcar.domain.BoardVO;
import com.spring.rentcar.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO dao;
	
	/*
	@Test
	public void createBoard() throws Exception{
		
		
		for(int i = 1; i <= 100; i++) {
			
			BoardVO vo = new BoardVO();
			vo.setTitle(i+"번째글");
			vo.setContent(i+"번째내용");
			vo.setWriter("test"+i);
			
			dao.create(vo);
			
		}
	}
	*/
	
	/*
	@Test
	public void readBoard() throws Exception{
		
		logger.info("read:"+dao.read(1));
	}
	
	
	@Test
	public void updateBoard() throws Exception{
		
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("첫번째글 update함");
		
		dao.update(vo);
	}
	
	@Test
	public void deleteBoard() throws Exception{
		
		dao.delete(1);
	}
	
	*/
	
	/*
	@Test
	public void listPaging() throws Exception{
		
		int page = 3;
		
		
		List<BoardVO> list = dao.listPaging(page);
		
		for (BoardVO boardVO : list) {
			
			logger.info(boardVO.getBno()+":"+ boardVO.getTitle());
		}
	}
	*/
	
	/*
	@Test
	public void listCriteria() throws Exception{
		
		Criteria cri = new Criteria();
		
		cri.setPage(3);
		cri.setPerPageNum(10);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+ boardVO.getTitle());
		}
	}
	*/
	
	/*
	@Test
	public void testURI() throws Exception{
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
															.path("/board/read")
															.queryParam("bno", 12)
															.queryParam("perPageNum", 20)
															.build();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
		
	}
	*/
	
	/*
	@Test
	public void search() throws Exception{
		
		PageMaker pageMaker = new PageMaker();
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setKeyWord("78");
		cri.setSearchType("t");
		cri.setPage(1);
		cri.setPerPageNum(10);
		
		
		pageMaker.setCri(cri);
		
		
		List<BoardVO> list = dao.listSearchCriteria(cri);

		for (BoardVO boardVO : list) {
			
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
		
		
	}
	*/
	
	
}
