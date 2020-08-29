package com.spring.rentcar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.rentcar.domain.ProductVO;

@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	

	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public void doA() throws Exception{
		
		logger.info("doA called");
	}
	
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public void doB() throws Exception{
		
		logger.info("doB called");
	}
	
	@RequestMapping(value = "/doC")
	public String doC(@ModelAttribute("msg") String msg) throws Exception{
		
		logger.info("doC called"+msg);
		
		return "result";
	}
	
	@RequestMapping(value = "/doD")
	public String doD(Model model) throws Exception{
		
		ProductVO product = new ProductVO("sample Product", 10000);
		logger.info("doD called");
		
		model.addAttribute(product);
		
		return "productDetail";
	}
	
	@RequestMapping(value = "/doE")
	public String doE(RedirectAttributes rttr) throws Exception{
		
		logger.info("doE called redirect to /doF");
		
		rttr.addFlashAttribute("msg", "This is the Message with redirected");
		return "redirect:/doF";
	}
	
	@RequestMapping(value = "/doF")
	public void doF(@ModelAttribute String msg) throws Exception{
		
		logger.info("doF called:"+msg);
	}
	
	@RequestMapping("/doJSON")
	@ResponseBody
	public ProductVO doJSON() throws Exception{
		
		ProductVO vo = new ProductVO("샘플상품", 30000);
		
		return vo;
		
		
	}
	
	
}
