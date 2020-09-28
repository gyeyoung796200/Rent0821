package com.spring.rentcar.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.rentcar.commons.Criteria;
import com.spring.rentcar.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	private static final String namespace = "com.spring.rentcar.replyMapper";

	@Inject
	private SqlSession session;
	
	@Override
	public List<ReplyVO> list(int bno) throws Exception {

		return session.selectList(namespace+".list", bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {

		session.insert(namespace+".create", vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {

		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(int rno) throws Exception {

		session.delete(namespace+".delete", rno);
	}

	@Override
	public List<ReplyVO> listPaging(int bno, Criteria cri) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bno", bno);
		map.put("cri", cri);
		
		return session.selectList(namespace+".listPaging", map );
	}

	@Override
	public int countReply(int bno) throws Exception {

		return session.selectOne(namespace+".countReply", bno);
	}

}
