package com.spring.rentcar.service;

import java.util.List;

import com.spring.rentcar.domain.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> list(int bno) throws Exception;
	
	public void create(ReplyVO vo) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
	
	public void delete(int rno) throws Exception;
}
