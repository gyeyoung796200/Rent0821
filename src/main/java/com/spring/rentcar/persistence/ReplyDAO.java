package com.spring.rentcar.persistence;

import java.util.List;

import com.spring.rentcar.commons.Criteria;
import com.spring.rentcar.domain.ReplyVO;

public interface ReplyDAO {

	public List<ReplyVO> list(int bno) throws Exception;
	
	public void create(ReplyVO vo) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
	
	public void delete(int rno) throws Exception;
	
	
	public List<ReplyVO> listPaging(int bno, Criteria cri) throws Exception;
	
	public int countReply(int bno) throws Exception;
	
	
	
}
