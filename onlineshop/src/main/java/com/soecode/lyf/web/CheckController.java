package com.soecode.lyf.web;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.css.ElementCSSInlineStyle;

import com.soecode.lyf.entity.Orderdetail;
import com.soecode.lyf.entity.Orders;
import com.soecode.lyf.entity.ShopCartItem;
import com.soecode.lyf.service.ChecksService;
import com.soecode.lyf.service.OrderdetailService;
import com.soecode.lyf.service.OrdersService;
import com.soecode.lyf.service.ShopCartItemService;

@Controller
@RequestMapping("/check") // url:/模块/资源/{id}/细分 /seckill/list
public class CheckController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private OrderdetailService orderdetailService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private ChecksService checkService;
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	private void check()
	{
		System.out.println("check into");
		String  posString =  request.getParameter("pos");
		String [] pos_list = posString.split(",");
				
		long pos_no = Long.parseLong(pos_list[0]);
		String cntry = pos_list[2];
		
		System.out.println("pos_no=" + pos_no + ",cntry= " + cntry);
		
		String product_ids = request.getParameter("product_ids");
		String quantity_nums = request.getParameter("quantity_nums");
		
		String [] product_id_list = product_ids.split(",");
		String [] quantity_nums_list = quantity_nums.split(",");
		
		if( product_id_list.length != quantity_nums_list.length )
			return;
		
		System.out.println(product_id_list[0] + ", " + quantity_nums_list[0]);

		//1、整合信息进行API调用
		int check_result = 1;
		long result_id = 0L;
		
		//2、将验证结果保存到数据库中
		Timestamp current_time = new Timestamp(System.currentTimeMillis()); 
		int ret = checkService.insert(current_time, pos_no, check_result, result_id);
		if(ret != 1 )
		{
			System.out.println("checkService.insert fail=" + ret);
		}
		
		if(check_result != 1)
		{
			String data = result_id + "";
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
		
		//3、更新orderdetail表
		if(check_result == 1)
		{
			try{
				for(int i = 0; i < product_id_list.length; i ++)
				{
					if(product_id_list[i].equals(""))
						continue;
					
					long pid =  Long.parseLong(product_id_list[i]);
					int pnum = Integer.parseInt(quantity_nums_list[i]);
					int left = pnum;
					
					List<Orderdetail> shopCartItems = orderdetailService.getUnbuyedListByProductId(pid);
					Iterator<Orderdetail> iterator = shopCartItems.iterator();
					while( left > 0 && iterator.hasNext() )
					{
						Orderdetail item = iterator.next();
						if( item.getQuantity() > left )
						{
							int test = item.getQuantity() - left;
							System.out.println("item.getQuantity() = " + item.getQuantity() + ", left=" + left);
							System.out.println("test = " + test);
							orderdetailService.insert(item.getName(), left, item.getProductId(), item.getOrderId(), 1);
							orderdetailService.update(item.getId(), test, item.getStatus());
							left = 0;
						}
						else if(item.getQuantity() == left)
						{
							orderdetailService.update(item.getId(), item.getQuantity(), 1);
							left = 0;
						}
						else if( item.getQuantity() > 0 )
						{
							orderdetailService.update(item.getId(), item.getQuantity(), 1);
							left = left - item.getQuantity();
						}
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getStackTrace());
			}
		}
		
		//4、更新order表
		List<Orders> orders = ordersService.getUnfinishedList();
		Iterator<Orders> iterator = orders.iterator();
		while(iterator.hasNext())
		{
			int finished = 1;
			Orders order = iterator.next();
			List<Orderdetail> orderdetails = orderdetailService.getListByOrderId(order.getId());
			
			Iterator<Orderdetail> orderDetailIterator = orderdetails.iterator();
			while(orderDetailIterator.hasNext())
			{
				Orderdetail od = orderDetailIterator.next();
				if(od.getStatus() == 0)
				{
					finished = 0;
					break;
				}
			}
			
			if(finished == 1)
			{
				ordersService.update(order.getId(), 1);
				//send email or ohone text 此处应该发送email或短信通知消费者
			}
		}
		
		//5、发送验证结果
		System.out.println("check = ");
		String data = "1";
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

}
