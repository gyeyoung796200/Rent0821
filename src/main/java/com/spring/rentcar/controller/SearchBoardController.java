package com.spring.rentcar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.rentcar.commons.PageMaker;
import com.spring.rentcar.commons.SearchCriteria;
import com.spring.rentcar.domain.BoardVO;
import com.spring.rentcar.service.BoardService;

@Controller
@RequestMapping("/sboard")
public class SearchBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	
	@RequestMapping(value = "/listCriteria", method = RequestMethod.GET)
	public ModelAndView listCriteria(@ModelAttribute("cri")SearchCriteria cri) throws Exception{
		
		logger.info("listPaging sboard get");
		
		ModelAndView mav = new ModelAndView();
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		
		
		int totalCount = service.searchTotalCount(cri);
		
		int rownum = totalCount -(cri.getPage() -1) * cri.getPerPageNum();
		
		logger.info("총글의개수:"+totalCount);
		
		mav.addObject("totalCount", totalCount);
		mav.addObject("rownum", rownum);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("boardVO", service.listSearchCriteria(cri));
		mav.addObject("center", "sboard/listCriteria.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ModelAndView readGET(@RequestParam("bno")int bno, @ModelAttribute("cri")SearchCriteria cri) throws Exception{
		
		logger.info("read sboard get");
		
		ModelAndView mav = new ModelAndView();
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("boardVO", service.read(bno));
		mav.addObject("center", "sboard/read.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePOST(@RequestParam("bno")int bno, @ModelAttribute("cri")SearchCriteria cri) throws Exception{
		
		
		logger.info("delete board post");
		
		service.delete(bno);
		
		ModelAndView mav = new ModelAndView();
					
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("totalCount", service.searchTotalCount(cri));
		mav.addObject("boardVO", service.listSearchCriteria(cri));
		mav.addObject("center", "sboard/listCriteria.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modifyGET(@RequestParam("bno")int bno, @ModelAttribute("cri")SearchCriteria cri) throws Exception{
		
		logger.info("modify board get");
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardVO", service.read(bno));
		mav.addObject("center", "sboard/modify.jsp");
		mav.setViewName("home");
		
		return mav;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modifyPOST(BoardVO boardVO, SearchCriteria cri) throws Exception{
		
		logger.info("modify board post");
		
		ModelAndView mav = new ModelAndView();
		
		service.update(boardVO);

		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		list = service.listSearchCriteria(cri);
		
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("boardVO", list);
		mav.addObject("center", "sboard/listCriteria.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createGET(SearchCriteria cri ) throws Exception{
		
		logger.info("create board get");
		
		ModelAndView mav = new ModelAndView();
		
		logger.info("page:"+cri.getPage());
		logger.info("page:"+cri.getPerPageNum());
		
		mav.addObject("cri", cri);
		mav.addObject("center", "sboard/create.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPOST(BoardVO boardVO, SearchCriteria cri) throws Exception{
		
		logger.info("create board post");
		
		logger.info("page:"+cri.getPage());
		logger.info("page:"+cri.getPerPageNum());
		
		ModelAndView mav = new ModelAndView();
		
		service.create(boardVO);
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		
		List<BoardVO> list = service.listSearchCriteria(cri);
		
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("boardVO", list);
		mav.addObject("center", "sboard/listCriteria.jsp");
		mav.setViewName("home");
		
		return mav;
	}
	
	
}
