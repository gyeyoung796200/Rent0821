package com.spring.rentcar.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.rentcar.domain.ReplyVO;
import com.spring.rentcar.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;

	@Override
	public List<ReplyVO> list(int bno) throws Exception {

		return dao.list(bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {

		dao.create(vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {

		dao.update(vo);
	}

	@Override
	public void delete(int rno) throws Exception {

		dao.delete(rno);
	}
	
}
