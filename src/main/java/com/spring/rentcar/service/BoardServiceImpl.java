package com.spring.rentcar.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.rentcar.commons.Criteria;
import com.spring.rentcar.commons.SearchCriteria;
import com.spring.rentcar.domain.BoardVO;
import com.spring.rentcar.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	
	@Override
	public void create(BoardVO boardVO) throws Exception {
		
		dao.create(boardVO);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
	
		return dao.read(bno);
	}
	

	@Override
	public void update(BoardVO boardVO) throws Exception {

		dao.update(boardVO);
	}

	@Override
	public void delete(Integer bno) throws Exception {

		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {

		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {

		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() throws Exception {

		return dao.totalCount();
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {

		return dao.listSearchCriteria(cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) throws Exception {

		return dao.searchTotalCount(cri);
	}

}
