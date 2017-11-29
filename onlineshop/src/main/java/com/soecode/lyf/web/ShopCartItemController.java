package com.soecode.lyf.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.soecode.lyf.entity.ShopCartItem;
import com.soecode.lyf.service.ProductService;
import com.soecode.lyf.service.ShopCartItemService;

@Controller
@RequestMapping("/shopcart") // url:/模块/资源/{id}/细分 /seckill/list
public class ShopCartItemController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShopCartItemService shopCartItemService;
	
	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
	private ModelAndView detail(@PathVariable("id") Long id, Model model)
	{
		System.out.println("id="+id);
		ModelAndView modelAndView = new ModelAndView("shopcart");
		
		List<ShopCartItem> shopCartItems = shopCartItemService.getListByUserId(id);
		modelAndView.addObject("cart_item_num", shopCartItems.size());
		modelAndView.addObject("cart_items", shopCartItems);
		
		List<Product> products = new ArrayList<Product>();
		List<Integer> productNums = new ArrayList<Integer>();
		Iterator<ShopCartItem> iterator = shopCartItems.iterator();
		while( iterator.hasNext() ){
			ShopCartItem item = iterator.next();
			Product product = productService.getById(item.getProductId());
			products.add(product);
			productNums.add(item.getQuantity());
		}
		
		modelAndView.addObject("products", products);
		modelAndView.addObject("productNums", productNums);
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}/add", method = RequestMethod.POST)
	private void add(@PathVariable("id") Long id, Model model)
	{
		long product_id = Long.parseLong(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		int affact_rows = 0;
		ShopCartItem item = shopCartItemService.getByRealId(id, product_id);
		if( item == null )
		{
			//插入一条记录
			affact_rows = shopCartItemService.insert( id, product_id, quantity);
			if( affact_rows != 1 )
			{
				System.out.println("insert affact_rows = " + affact_rows);
				affact_rows = 0;
			}
		}
		else
		{
			//更新一条记录
			affact_rows = shopCartItemService.update( id, product_id, quantity + item.getQuantity());
			if( affact_rows != 1 )
			{
				System.out.println("update affact_rows = " + affact_rows);
				affact_rows = 0;
			}
		}
		System.out.println("final affact_rows = " + affact_rows);
		
		List<ShopCartItem> items = shopCartItemService.getListByUserId(id);		
		String data = items.size() + "";
		try{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(data);
			out.close();
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return;
	}
	
	@RequestMapping(value = "/{id}/count", method = RequestMethod.GET)
	private void count(@PathVariable("id") Long id)
	{
		System.out.println("count");
		List<ShopCartItem> items = shopCartItemService.getListByUserId(id);		
		String data = items.size() + "";
		try{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(data);
			out.close();
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return;
	}
	
	@RequestMapping(value = "/purchase_num", method = RequestMethod.GET)
	private void purchase_num(@PathVariable("id") Long id)
	{
		System.out.println("count");
		List<ShopCartItem> items = shopCartItemService.getList();		
		String data = items.size() + "";
		try{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(data);
			out.close();
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return;
	}
	
	@RequestMapping(value = "/purchase_list", method = RequestMethod.GET)
	private ModelAndView purchase_list()
	{
		ModelAndView modelAndView = new ModelAndView("shopcart");
		
		List<ShopCartItem> shopCartItems = shopCartItemService.getList();
		modelAndView.addObject("cart_item_num", shopCartItems.size());
		modelAndView.addObject("cart_items", shopCartItems);
		
		List<Product> products = new ArrayList<Product>();
		List<Integer> productNums = new ArrayList<Integer>();
		Iterator<ShopCartItem> iterator = shopCartItems.iterator();
		while( iterator.hasNext() ){
			ShopCartItem item = iterator.next();
			Product product = productService.getById(item.getProductId());
			products.add(product);
			productNums.add(item.getQuantity());
		}
		
		modelAndView.addObject("products", products);
		modelAndView.addObject("productNums", productNums);
		return modelAndView;
	}

}
