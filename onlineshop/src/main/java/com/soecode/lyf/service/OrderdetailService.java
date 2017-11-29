package com.soecode.lyf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.OrderGroup;
import com.soecode.lyf.entity.Orderdetail;

public interface OrderdetailService {
	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	Orderdetail getById(long id);

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Orderdetail> getList();
	
	List<OrderGroup> getSumList();
	
	List<Orderdetail> getListByOrderId(long orderId);
	
	List<Orderdetail> getUnbuyedListByOrderId(long orderId);
	
	List<Orderdetail> getUnbuyedListByProductId(long productId);
	
	List<Orderdetail> getUnbuyedList();
	
	int insert(String name, int quantity, long productId, long orderId, int status);
	
	int update(long id, int quantity, int status);

}
