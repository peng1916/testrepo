package com.soecode.lyf.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soecode.lyf.entity.OrderGroup;
import com.soecode.lyf.entity.Orderdetail;
import com.soecode.lyf.entity.Orders;
import com.soecode.lyf.entity.Product;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.OrderdetailService;
import com.soecode.lyf.service.OrdersService;
import com.soecode.lyf.service.ProductService;
import com.soecode.lyf.service.UserService;

@Controller
@RequestMapping("/order") // url:/模块/资源/{id}/细分 /seckill/list
public class OrderController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrderdetailService orderdetailService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	/*
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

	*/
	@RequestMapping(value = "/purchase_list", method = RequestMethod.GET)
	private ModelAndView purhcase_list()
	{
		System.out.println("purhcase_list");
		ModelAndView modelAndView = new ModelAndView("purchase");
		
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
		
		modelAndView.addObject("products", products);
		modelAndView.addObject("productNums", productNums);
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}/pay", method = RequestMethod.GET)
	private ModelAndView pay(@PathVariable("id") Long id)
	{
		System.out.println("pay=" + id);
		ModelAndView modelAndView = new ModelAndView("pay");
		String product_ids = request.getParameter("product_ids");
		String quantity_nums = request.getParameter("quantity_nums");

		String [] product_id_list = product_ids.split(",");
		String [] quantity_nums_list = quantity_nums.split(",");

		//1、获取用户数据
		User user = userService.getById(id);
		if( user == null )
			return null;
		
		modelAndView.addObject("user_name", user.getName());
		modelAndView.addObject("user_address", user.getAddress());
		modelAndView.addObject("user_phone", user.getPhone());
		modelAndView.addObject("user_email", user.getMail());
		
		//2、计算总价
		int sum = 0;
		for( int i = 0; i < quantity_nums_list.length; i ++ )
		{
			if(quantity_nums_list[i].equals(""))
				continue;
			
			long pid =  Long.parseLong(product_id_list[i]);
			int pnum = 0;
			try{
				pnum = Integer.parseInt(quantity_nums_list[i]);
				long price = productService.getById(pid).getPrice();
				sum = sum + (int)(price) * pnum;
			} catch(Exception e)
			{
				System.out.println(e.getStackTrace());
			}
			
		}
		modelAndView.addObject("sum_price", sum);
		
		//3、插入order表
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Orders orders = new Orders();
		orders.setAddress(user.getAddress());
		orders.setCustomerId(user.getId());
		orders.setOrderMoney(sum);
		orders.setOrderSt(0);
		orders.setOrderTime(timestamp);
		orders.setPayTime(timestamp);
		orders.setPhone(user.getPhone());
		ordersService.insertOrder(orders);
		modelAndView.addObject("order_id", orders.getId());

		//long orderId = ordersService.insert(timestamp, timestamp, sum, 0, user.getAddress(), user.getPhone(), user.getId());
		System.out.println("orderID=" + orders.getId());
		//4、插入orderdetail表
		for( int i = 0; i < product_id_list.length; i ++ )
		{
			if(product_id_list[i].equals(""))
				continue;
			long pid =  Long.parseLong(product_id_list[i]);
			int pnum = 0;
			try{
				pnum = Integer.parseInt(quantity_nums_list[i]);
			} catch(Exception e)
			{
				System.out.println(e.getStackTrace());
			}
			
			Product product = productService.getById(pid);
			orderdetailService.insert(product.getName(), pnum, pid, orders.getId(), 0);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}/success", method = RequestMethod.GET)
	private ModelAndView success(@PathVariable("id") Long id)
	{
		System.out.println("success=" + id);
		ModelAndView modelAndView = new ModelAndView("success");
		
		Orders orders = ordersService.getById(id);
		User user = userService.getById(orders.getCustomerId());
		
		
		modelAndView.addObject("user_name", user.getName());
		modelAndView.addObject("order_address", orders.getAddress());
		modelAndView.addObject("order_price", orders.getOrderMoney() );
		modelAndView.addObject("order_phone", orders.getPhone());
		
		return modelAndView;
	}

}
