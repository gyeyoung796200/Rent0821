package com.spring.rentcar.persistence;

import java.util.List;

import com.spring.rentcar.domain.BoardVO;

public interface BoardDAO {

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
	
}
