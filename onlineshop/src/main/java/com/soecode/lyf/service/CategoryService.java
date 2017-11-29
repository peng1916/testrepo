package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.entity.Category;

public interface CategoryService {
	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	Category getById(long id);

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Category> getList();
}
