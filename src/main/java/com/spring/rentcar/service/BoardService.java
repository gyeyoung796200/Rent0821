package com.spring.rentcar.service;

import java.util.List;

import com.spring.rentcar.commons.Criteria;
import com.spring.rentcar.commons.SearchCriteria;
import com.spring.rentcar.domain.BoardVO;

public interface BoardService {

	//글쓰기
	public void create(BoardVO boardVO) throws Exception;
	
	//글읽기
	public BoardVO read(Integer bno) throws Exception;
	
	//글수정
	public void update(BoardVO boardVO) throws Exception;
	
	//글삭제
	public void delete(Integer bno) throws Exception;
	
	//글목록
	public List<BoardVO> listAll() throws Exception;
	
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int totalCount() throws Exception;
	
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int searchTotalCount(SearchCriteria cri) throws Exception;
}
