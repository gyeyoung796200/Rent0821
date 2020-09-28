package com.spring.rentcar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.rentcar.domain.SampleVO;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/ajax")
public class RestController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		
		return "hello world";
	}
	
	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		
		SampleVO vo = new SampleVO();
		
		vo.setMno(1);
		vo.setFirstName("홍");
		vo.setLastName("길동");
		
		return vo;
	}
	
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i = 0; i < 10 ; i++) {
			
			SampleVO vo = new SampleVO();
			
			vo.setMno(i);
			vo.setFirstName(i+"이름");
			vo.setLastName(i+"마지막");
			
			list.add(vo);
		}
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap(){
		
		Map<Integer, SampleVO> map = new HashMap<Integer, SampleVO>();
		
		for(int i = 0 ; i < 10;i++) {
			
			SampleVO vo  = new SampleVO();
			vo.setMno(i);
			vo.setFirstName(i+"이름");
			vo.setLastName(i+"마지막");
			
			map.put(i, vo);
		}
		return map;
	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot(){
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i=0; i< 10; i++) {
			
			SampleVO vo  = new SampleVO();
			vo.setMno(i);
			vo.setFirstName(i+"이름");
			vo.setLastName(i+"마지막");
			
			list.add(vo);
		}

		return new ResponseEntity<List<SampleVO>>(list, HttpStatus.NOT_FOUND);
		
	}
	
}
