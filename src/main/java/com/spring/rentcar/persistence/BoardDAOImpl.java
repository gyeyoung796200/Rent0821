package com.spring.rentcar.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.rentcar.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final String namespace = "com.spring.rentcar.boardMapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public void create(BoardVO boardVO) throws Exception {
		
		session.insert(namespace+".create", boardVO);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {

		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
