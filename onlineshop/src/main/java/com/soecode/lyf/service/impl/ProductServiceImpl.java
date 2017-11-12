package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.ProductDao;
import com.soecode.lyf.entity.Product;
import com.soecode.lyf.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getById(long id) {
		return productDao.queryById(id);
	}

	@Override
	public List<Product> getList() {
		return productDao.queryAll(0, 1000);
	}

}
