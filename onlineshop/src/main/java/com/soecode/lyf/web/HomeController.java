package com.soecode.lyf.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home") // url:/模块/资源/{id}/细分 /seckill/list
public class HomeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	private ModelAndView main(Model model)
	{
		ModelAndView modelAndView=new ModelAndView("home");
		return modelAndView;
		
	}
}
