package com.soecode.lyf.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soecode.lyf.entity.OrderGroup;
import com.soecode.lyf.entity.Product;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.OrderdetailService;
import com.soecode.lyf.service.ProductService;
import com.soecode.lyf.service.UserService;

@Controller
@RequestMapping("/user") // url:/模块/资源/{id}/细分 /seckill/list
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderdetailService orderdetailService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView page(Model model)
	{
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model)
	{
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println("role=" + request.getParameter("role") + ", and name=" + name);
		int role = Integer.parseInt(request.getParameter("role"));
		
		System.out.println("role=" + role);
				
		ModelAndView modelAndView = new ModelAndView("home");
		User userLogin = userService.getByPass(name, password, role);
		if(userLogin == null)
		{
			modelAndView.setViewName("login");
		}
		else
		{
			boolean idExist = false, nameExist = false, roleExist = false;
			
			Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
			for(Cookie cookie : cookies){
				if( cookie.getName().equals("user_id") )
				{
					cookie.setValue(userLogin.getId() + "" );
					cookie.setMaxAge(3600);			 
					cookie.setPath("/");
					idExist = true;
				}
				else if( cookie.getName().equals("user_name") )
				{
					cookie.setValue(userLogin.getName() + "" );
					cookie.setMaxAge(3600);			 
					cookie.setPath("/");
					nameExist = true;
				}
				else if( cookie.getName().equals("role") )
				{
					cookie.setValue(userLogin.getRole() + "" );
					cookie.setMaxAge(3600);			 
					cookie.setPath("/");
					roleExist = true;
				}
			    System.out.println("what:" + cookie.getName() + "=" + cookie.getValue());
			}
			
			if(!idExist)
			{
				Cookie cookieId = new Cookie("user_id", userLogin.getId() + "");
				cookieId.setMaxAge(3600);			 
				cookieId.setPath("/");
				response.addCookie(cookieId);
			}
			
			if(!nameExist)
			{
				Cookie cookieName = new Cookie("user_name", userLogin.getName());
				cookieName.setMaxAge(3600);			 
				cookieName.setPath("/");			
				response.addCookie(cookieName);

			}
			
			if(!roleExist)
			{
				Cookie cookieRole = new Cookie("role", userLogin.getRole());
				cookieRole.setMaxAge(3600);			 
				cookieRole.setPath("/");

				response.addCookie(cookieRole);
			}

		    System.out.println("userLogin.getRole() :" + userLogin.getRole() );

			if( userLogin.getRole().equals("0") )
			{
				//modelAndView.setViewName("redirect:/home/main");
				modelAndView.setViewName("home");
			}
			else{				
				//modelAndView.setViewName("redirect:/order/purchase_list");
				
				List<OrderGroup> orderGroups = orderdetailService.getSumList();
				if(orderGroups == null)
				{
					System.out.println("purhcase_list");
					return null;
				}
				System.out.println("orderGroups.size()="+orderGroups.size());
				modelAndView.addObject("cart_item_num", orderGroups.size());
				
				List<Product> products = new ArrayList<Product>();
				List<Integer> productNums = new ArrayList<Integer>();
				Iterator<OrderGroup> iterator = orderGroups.iterator();
				while( iterator.hasNext() ){
					OrderGroup item = iterator.next();
					Product product = productService.getById(item.getProductId());
					products.add(product);
					productNums.add(item.getSum());
					
					System.out.println("item.getSum()="+item.getSum());
				}
				System.out.println("products.size()="+products.size());
				modelAndView.setViewName("purchase");
				modelAndView.addObject("products", products);
				modelAndView.addObject("productNums", productNums);
			}

		}

		return modelAndView;
	}
}
