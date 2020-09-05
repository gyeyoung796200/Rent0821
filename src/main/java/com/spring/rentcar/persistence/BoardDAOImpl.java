package com.spring.rentcar.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.rentcar.commons.Criteria;
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

		session.update(namespace+".update", boardVO);
	}

	@Override
	public void delete(Integer bno) throws Exception {

		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {

		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listPaging(int page) throws Exception {
		
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;

		return session.selectList(namespace+".listPaging", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {

		return session.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public int totalCount() throws Exception {
		
		return session.selectOne(namespace+".totalCount");
	}

}
