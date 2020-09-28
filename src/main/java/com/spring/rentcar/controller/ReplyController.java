package com.spring.rentcar.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rentcar.domain.ReplyVO;
import com.spring.rentcar.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	private ReplyService replyService;
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO replyVO) throws Exception{
		
		ResponseEntity<String> entity = null;
		
		try {
			replyService.create(replyVO);
			entity = new ResponseEntity<String>("regSuccess",HttpStatus.OK);

		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno")int bno) throws Exception{
		
		ResponseEntity<List<ReplyVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<ReplyVO>>(replyService.list(bno), HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.PATCH)
	public ResponseEntity<String> update(@PathVariable("rno")int rno, @RequestBody ReplyVO replyVO) throws Exception{
		
		ResponseEntity<String> entity = null;
		
		try {
			replyVO.setRno(rno);
			replyService.update(replyVO);
			entity = new ResponseEntity<String>("modSuccess", HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno")int rno) throws Exception{
		
		ResponseEntity<String> entity = null;
		
		try {
			
			replyService.delete(rno);
			entity = new ResponseEntity<String>("delSuccess", HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
	
}
