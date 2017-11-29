package com.soecode.lyf.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Orders;

public interface OrdersService {
	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	Orders getById(long id);

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Orders> getList();
	
	List<Orders> getFinishedList();
	
	List<Orders> getUnfinishedList();
	
	int insert(Timestamp orderTime, Timestamp payTime, 
			int orderMoney, int orderSt, 
			String address, String phone, 
			long customId);
	
	int update(long id, int orderSt);
	
	int insertOrder(Orders order);
}
