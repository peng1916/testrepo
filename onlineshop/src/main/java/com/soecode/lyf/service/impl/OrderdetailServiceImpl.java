package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.OrderdetailDao;
import com.soecode.lyf.entity.OrderGroup;
import com.soecode.lyf.entity.Orderdetail;
import com.soecode.lyf.service.OrderdetailService;

@Service
public class OrderdetailServiceImpl implements OrderdetailService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private OrderdetailDao orderdetailDao;

	@Override
	public Orderdetail getById(long id) {
		return orderdetailDao.queryById(id);
	}

	@Override
	public List<Orderdetail> getList() {
		return orderdetailDao.queryAll(0, 1000);
	}
	
	@Override
	public List<OrderGroup> getSumList() {
		return orderdetailDao.querySum(0, 1000);
	}

	@Override
	public List<Orderdetail> getListByOrderId(long orderId) {
		// TODO Auto-generated method stub
		return orderdetailDao.queryAllByOrdersId(orderId, 0, 1000);
	}

	@Override
	public List<Orderdetail> getUnbuyedListByOrderId(long orderId) {
		// TODO Auto-generated method stub
		return orderdetailDao.queryUnbuyedAllByOrdersId(orderId, 0, 1000);
	}

	@Override
	public List<Orderdetail> getUnbuyedList() {
		// TODO Auto-generated method stub
		return orderdetailDao.queryUnbuyedAll(0, 1000);
	}

	@Override
	public List<Orderdetail> getUnbuyedListByProductId(long productId) {
		// TODO Auto-generated method stub
		return orderdetailDao.queryUnbuyedAllByProductId(productId, 0, 1000);
	}

	@Override
	public int insert(String name, int quantity, long productId, long orderId, int status) {
		// TODO Auto-generated method stub
		return orderdetailDao.insert(name, quantity, productId, orderId, status);
	}

	@Override
	public int update(long id, int quantity, int status) {
		// TODO Auto-generated method stub
		System.out.println("quantity="+quantity);
		return orderdetailDao.update(id, quantity, status);
	}

}
