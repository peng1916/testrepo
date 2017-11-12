package com.soecode.lyf.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soecode.lyf.entity.Product;
import com.soecode.lyf.service.ProductService;

@Controller
@RequestMapping("/product") // url:/模块/资源/{id}/细分 /seckill/list
public class ProductController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
	private ModelAndView detail(@PathVariable("id") Long id, Model model) {
		if (id == null) {
			ModelAndView modelAndView = new ModelAndView("error");
			logger.error("ProductController->detail(id == null");
			return modelAndView;
		}
		Product product = productService.getById(id);
		if (product == null) {
			ModelAndView modelAndView = new ModelAndView("error");
			logger.error("ProductController->detail(product == null) id=[" + id + "]");
			return modelAndView;
		}
		
		System.out.println("main_image_url1="+ product.getMainImageUrl1() );
		
		model.addAttribute("product", product);
		ModelAndView modelAndView = new ModelAndView("introduction");
		modelAndView.addObject("product", product);
		return modelAndView;
	}


}
