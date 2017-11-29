package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.entity.ShopCartItem;

public interface ShopCartItemService {
	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */	
	ShopCartItem getByRealId(long user_id, long product_id);

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<ShopCartItem> getList();
	
	List<ShopCartItem> getListByUserId(long user_id);
	
	int insert( long user_id, long product_id, int quantity );
	
	int update( long user_id, long product_id, int quantity );
}

