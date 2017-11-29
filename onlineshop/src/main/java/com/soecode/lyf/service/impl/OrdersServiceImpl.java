package com.soecode.lyf.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.OrdersDao;
import com.soecode.lyf.entity.Orders;
import com.soecode.lyf.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public Orders getById(long id) {
		return ordersDao.queryById(id);
	}

	@Override
	public List<Orders> getList() {
		return ordersDao.queryAll(0, 1000);
	}

	@Override
	public List<Orders> getFinishedList() {
		// TODO Auto-generated method stub
		return ordersDao.queryFinishedAll(0, 1000);
	}

	@Override
	public List<Orders> getUnfinishedList() {
		// TODO Auto-generated method stub
		return ordersDao.queryUnfinishedAll(0, 1000);
	}

	@Override
	public int insert(Timestamp orderTime, Timestamp payTime, int orderMoney, int orderSt, String address, String phone,
			long customId) {
		// TODO Auto-generated method stub
		return ordersDao.insert(orderTime, payTime, orderMoney, orderSt, address, phone, customId);
	}

	@Override
	public int update(long id, int orderSt) {
		// TODO Auto-generated method stub
		return ordersDao.update(id, orderSt);
	}

	@Override
	public int insertOrder(Orders order) {
		// TODO Auto-generated method stub
		return ordersDao.insertOrder(order);
	}

}
