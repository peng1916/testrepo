package com.soecode.lyf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.User;

public interface UserService {
	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	User getById(long id);

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<User> getList();
	
	User getByPass( String name, String password, int role );
}
