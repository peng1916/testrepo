package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.entity.Product;

public interface ProductService {
	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	Product getById(long id);

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Product> getList();
}
