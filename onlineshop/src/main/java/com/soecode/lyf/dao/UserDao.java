package com.soecode.lyf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.User;

public interface UserDao {
	/**
	 * 通过ID查询单本图书
	 * 
	 * @param id
	 * @return
	 */
	User queryById(long id);

	/**
	 * 查询所有图书
	 * 
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 通过ID查询单本图书
	 * 
	 * @param id
	 * @return
	 */
	User queryByPass(@Param("name")String name, @Param("password")String password, @Param("role")int role);

	/**
	 * 减少馆藏数量
	 * 
	 * @param id
	 * @param num
	 * @return 如果影响行数等于>num，表示更新的记录行数
	 */
	//int reduceNumber(long id, int num);

}
