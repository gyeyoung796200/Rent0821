package com.spring.rentcar.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.rentcar.commons.Criteria;
import com.spring.rentcar.commons.PageMaker;
import com.spring.rentcar.commons.SearchCriteria;
import com.spring.rentcar.domain.BoardVO;
import com.spring.rentcar.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createGET() throws Exception{
		
		logger.info("get Create Form");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("center", "board/create.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPOST(BoardVO boardVO) throws Exception{
		
		logger.info("post Create Form");
		
		ModelAndView mav = new ModelAndView();
	
		service.create(boardVO);
		
		List<BoardVO> list = service.listAll();
		
		mav.addObject("boardVO", list);
		mav.addObject("center", "board/list.jsp");
		mav.setViewName("home");
//		mav.setViewName("redirect:/board/list");
//		mav.setViewName("redirect:/");
		
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listGET() throws Exception{
		
		logger.info("get board list");
		
		ModelAndView mav = new ModelAndView();
		
		List<BoardVO> list = service.listAll();
		
		mav.addObject("boardVO", list);
		mav.addObject("center", "board/list.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ModelAndView readGET(@RequestParam("bno")int bno, @ModelAttribute("cri")Criteria cri) throws Exception{
		
		logger.info("get board read");
		
		ModelAndView mav = new ModelAndView();
		
		logger.info("글 번호:"+bno);
		
		mav.addObject("boardVO", service.read(bno));
		mav.addObject("center", "board/read.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/delete") //기본criteria
	public ModelAndView deletePOST(@RequestParam("bno")int bno, SearchCriteria cri ) throws Exception{
		
		logger.info("delete board post");
		
		ModelAndView mav = new ModelAndView();
		
		service.delete(bno);

		
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount());
		
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("cri", cri);
		mav.addObject("boardVO", service.listCriteria(cri));
		mav.addObject("center", "board/listCriteria.jsp");
		
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modifyGET(@RequestParam("bno")int bno, SearchCriteria cri) throws Exception{
		
		logger.info("modify board get");
		
		ModelAndView mav = new ModelAndView();
		
		BoardVO vo = service.read(bno);
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		
		
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("cri", cri);

		mav.addObject("boardVO", vo);
		mav.addObject("center", "board/modify.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modifyPOST(BoardVO boardVO, SearchCriteria cri) throws Exception{
		
		logger.info("modify board post");
		
		ModelAndView mav = new ModelAndView();
		
		logger.info("글제목:"+boardVO.getTitle());
		logger.info("글내용:"+boardVO.getContent());
		
		service.update(boardVO);
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount());
		
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("cri", cri);
		mav.addObject("boardVO", service.listCriteria(cri));
		
		mav.addObject("center", "board/listCriteria.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
	public ModelAndView listCriteria(SearchCriteria cri) throws Exception{   //Criteria에는 현재 페이지와 페이지당 글의 개수가 저장되어있음
		
		logger.info("listCriteria board get");
		
		ModelAndView mav = new ModelAndView();
		
		PageMaker pageMaker = new PageMaker();  //pageMaker의 계산을 위해 생성하고 
		
		pageMaker.setCri(cri); //얻어온 현재페이지를 pageMaker에 넣어 계산할준비를하고
		pageMaker.setTotalCount(service.totalCount()); //총 글의개수가 구해지면 나머지들이 계산되기시작함
		
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("boardVO", service.listCriteria(cri));
		mav.addObject("center", "board/listCriteria.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	
}
