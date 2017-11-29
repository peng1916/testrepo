package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.CategoryDao;
import com.soecode.lyf.entity.Category;
import com.soecode.lyf.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category getById(long id) {
		return categoryDao.queryById(id);
	}

	@Override
	public List<Category> getList() {
		return categoryDao.queryAll(0, 1000);
	}

}
