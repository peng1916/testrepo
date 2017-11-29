package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.ShopCartItemDao;
import com.soecode.lyf.entity.ShopCartItem;
import com.soecode.lyf.service.ShopCartItemService;

@Service
public class ShopCartItemServiceImpl implements ShopCartItemService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private ShopCartItemDao shopCartItemDao;

	@Override
	public List<ShopCartItem> getList() {
		return shopCartItemDao.queryAll(0, 1000);
	}

	@Override
	public List<ShopCartItem> getListByUserId( long user_id ) {
		// TODO Auto-generated method stub
		return shopCartItemDao.queryAllByUserId(user_id, 0, 1000);
	}

	@Override
	public int insert(long user_id, long product_id, int quantity) {
		// TODO Auto-generated method stub
		return shopCartItemDao.insert(user_id, product_id, quantity);
	}

	@Override
	public int update(long user_id, long product_id, int quantity) {
		// TODO Auto-generated method stub
		return shopCartItemDao.update(user_id, product_id, quantity);
	}

	@Override
	public ShopCartItem getByRealId(long user_id, long product_id) {
		// TODO Auto-generated method stub
		return shopCartItemDao.queryById(user_id, product_id);
	}
	
	

}
